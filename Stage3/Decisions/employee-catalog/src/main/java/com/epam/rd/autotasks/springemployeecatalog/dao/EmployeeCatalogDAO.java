package com.epam.rd.autotasks.springemployeecatalog.dao;

import com.epam.rd.autotasks.springemployeecatalog.domain.Department;
import com.epam.rd.autotasks.springemployeecatalog.domain.Employee;
import com.epam.rd.autotasks.springemployeecatalog.domain.FullName;
import com.epam.rd.autotasks.springemployeecatalog.domain.Position;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeCatalogDAO {
    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";

    private static Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Employee> getEmployeesList(Optional<Integer> page, Optional<Integer> size, Optional<String> sortByValue){

        String sort = null;
        if(sortByValue.isPresent()){
            sort = sortByValue.get();
            if(sort.equals("hired"))
                sort  = "HIREDATE";
        }
            String sqlQuery = "SELECT * FROM EMPLOYEE";
            if(page.isPresent() && size.isPresent() && sortByValue.isPresent()){
                sqlQuery = "SELECT * FROM EMPLOYEE ORDER BY " + sort
                        + " LIMIT " + size.get() + " OFFSET " + page.get() * size.get();
            }
        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                Long id = resultSet.getObject("ID", Long.class);
                FullName fullName = new FullName(
                        resultSet.getObject("FIRSTNAME", String.class)
                        , resultSet.getObject("LASTNAME", String.class)
                        , resultSet.getObject("MIDDLENAME", String.class)
                );
                Position position = Position.valueOf(resultSet.getObject("POSITION", String.class));
                LocalDate localDate = LocalDate.parse(resultSet.getDate("HIREDATE").toString());
                BigDecimal salary = resultSet.getObject("SALARY", BigDecimal.class);

                Integer managerId = resultSet.getObject("MANAGER", Integer.class);
                Integer departmentId = resultSet.getObject("DEPARTMENT", Integer.class);

                Employee employee = new Employee(id,fullName, position, localDate, salary,
                        getManager(managerId),getDepartment(departmentId));

                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public List<Employee> getEmployeesByManagerId(int managerId, int page, int size, String sortByValue){
        if(sortByValue.equals("hired")){
            sortByValue = "HIREDATE";
        }
        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE MANAGER =" + managerId
                    + " ORDER BY " + sortByValue
                    + " LIMIT " + size + " OFFSET " + (page) * size);
            while (resultSet.next()){
                Long id = resultSet.getObject("ID", Long.class);
                FullName fullName = new FullName(
                        resultSet.getObject("FIRSTNAME", String.class)
                        , resultSet.getObject("LASTNAME", String.class)
                        , resultSet.getObject("MIDDLENAME", String.class)
                );
                Position position = Position.valueOf(resultSet.getObject("POSITION", String.class));
                LocalDate localDate = LocalDate.parse(resultSet.getDate("HIREDATE").toString());
                BigDecimal salary = resultSet.getObject("SALARY", BigDecimal.class);

                Integer manager = resultSet.getObject("MANAGER", Integer.class);
                Integer departmentId = resultSet.getObject("DEPARTMENT", Integer.class);

                Employee employee = new Employee(id,fullName, position, localDate, salary,
                        getManager(manager),getDepartment(departmentId));

                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public Employee getEmployeeById(int id, Optional<Boolean> getChain){

        try(Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE ID = " + id);

            while (resultSet.next()) {

                Long empId = resultSet.getObject("ID", Long.class);
                FullName fullName = new FullName(
                        resultSet.getObject("FIRSTNAME", String.class)
                        , resultSet.getObject("LASTNAME", String.class)
                        , resultSet.getObject("MIDDLENAME", String.class)
                );
                Position position = Position.valueOf(resultSet.getObject("POSITION", String.class));
                LocalDate localDate = LocalDate.parse(resultSet.getDate("HIREDATE").toString());
                BigDecimal salary = resultSet.getObject("SALARY", BigDecimal.class);

                Integer manager = resultSet.getObject("MANAGER", Integer.class);
                Integer departmentId = resultSet.getObject("DEPARTMENT", Integer.class);

                if(getChain.isEmpty() || getChain.get().equals(false)) {
                    return new Employee(empId, fullName, position, localDate, salary,
                            getManager(manager),
                            getDepartment(departmentId));
                }else {
                    return new Employee(empId, fullName, position, localDate, salary,
                            getEmployeeFullChain(manager),
                            getDepartment(departmentId));
                }
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        throw new RuntimeException();
    }

    public List<Employee> getEmployeeByDepartment(String departmentByValue, int page, int size, String sortByValue){
        if(sortByValue.equals("hired")){
            sortByValue = "HIREDATE";
        }

        String sqlQuery = null;
        boolean departmentByValueIsNumber = false;
        if(departmentByValue.matches("[-+]?\\d+")){
            departmentByValueIsNumber = true;
        }

        if(departmentByValueIsNumber){
            sqlQuery = "SELECT * FROM EMPLOYEE e LEFT JOIN DEPARTMENT d on " +
                    "e.DEPARTMENT = d.ID WHERE d.ID = "+Integer.parseInt(departmentByValue)+" ORDER BY " + sortByValue +
                    " LIMIT " + size + " OFFSET " + page * size;
        }else {
            sqlQuery = "SELECT * FROM EMPLOYEE e LEFT JOIN DEPARTMENT d on " +
                    "e.DEPARTMENT = d.ID WHERE d.NAME = '"+departmentByValue+"' ORDER BY " + sortByValue +
                    " LIMIT " + size + " OFFSET " + page * size;
        }

        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()){
                Long id = resultSet.getObject("ID", Long.class);
                FullName fullName = new FullName(
                        resultSet.getObject("FIRSTNAME", String.class)
                        , resultSet.getObject("LASTNAME", String.class)
                        , resultSet.getObject("MIDDLENAME", String.class)
                );
                Position position = Position.valueOf(resultSet.getObject("POSITION", String.class));
                LocalDate localDate = LocalDate.parse(resultSet.getDate("HIREDATE").toString());
                BigDecimal salary = resultSet.getObject("SALARY", BigDecimal.class);

                Integer managerId = resultSet.getObject("MANAGER", Integer.class);
                Integer departmentId = resultSet.getObject("DEPARTMENT", Integer.class);

                Employee employee = new Employee(id,fullName, position, localDate, salary,
                        getManager(managerId),getDepartment(departmentId));

                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeeList;
    }

    private Employee getEmployeeFullChain(Integer employee){
        try(Statement statement = connection.createStatement()){
            if(employee == null){
                return null;
            }
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE ID = " + employee);

            while (resultSet.next()) {

                Long id = resultSet.getObject("ID", Long.class);
                FullName fullName = new FullName(
                        resultSet.getObject("FIRSTNAME", String.class)
                        , resultSet.getObject("LASTNAME", String.class)
                        , resultSet.getObject("MIDDLENAME", String.class)
                );
                Position position = Position.valueOf(resultSet.getObject("POSITION", String.class));
                LocalDate localDate = LocalDate.parse(resultSet.getDate("HIREDATE").toString());
                BigDecimal salary = resultSet.getObject("SALARY", BigDecimal.class);

                Integer manager = resultSet.getObject("MANAGER", Integer.class);
                Integer departmentId = resultSet.getObject("DEPARTMENT", Integer.class);

                return new Employee(id,fullName, position, localDate, salary,
                        getEmployeeFullChain(manager),
                        getDepartment(departmentId));
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        throw new RuntimeException();
    }


    private Employee getManager(Integer managerId){
        if(managerId == null){
            return null;
        }
        Employee employee = null;
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE ID = " + managerId);
            while (resultSet.next()) {
                Long id = resultSet.getObject("ID", Long.class);
                FullName fullName = new FullName(
                        resultSet.getObject("FIRSTNAME", String.class)
                        , resultSet.getObject("LASTNAME", String.class)
                        , resultSet.getObject("MIDDLENAME", String.class)
                );
                Position position = Position.valueOf(resultSet.getObject("POSITION", String.class));
                LocalDate localDate = LocalDate.parse(resultSet.getDate("HIREDATE").toString());
                BigDecimal salary = resultSet.getObject("SALARY", BigDecimal.class);
                Integer manager = resultSet.getObject("MANAGER", Integer.class);
                Integer departmentId = resultSet.getObject("DEPARTMENT", Integer.class);
                employee = new Employee(id,fullName, position, localDate, salary,
                        null,
                        getDepartment(departmentId));
                return employee;
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return employee;
    }

    private Department getDepartment(Integer departmentId){
        Department department = null;
        if(departmentId == null){
            return null;
        }
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPARTMENT WHERE ID = " + departmentId);
            while (resultSet.next()) {
                Long id = resultSet.getObject("ID", Long.class);
                String name  = resultSet.getObject("NAME", String.class);
                String location  = resultSet.getObject("LOCATION", String.class);
                department = new Department(id,name,location);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return department;
    }
}
