package com.epam.rd.autocode.service;

import com.epam.rd.autocode.ConnectionSource;
import com.epam.rd.autocode.domain.Department;
import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private Connection connection;

    public EmployeeServiceImpl() {
        try {
            connection = ConnectionSource.instance().createConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllSortByHireDate(Paging paging) {
        return sortByAttribute(paging, "SELECT * FROM EMPLOYEE ORDER BY HIREDATE LIMIT ? OFFSET ?");
    }

    private List<Employee> sortByAttribute(Paging paging, String sql){

        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, paging.itemPerPage);
            statement.setObject(2, (paging.page-1) * paging.itemPerPage);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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
                        getManager(managerId, null),
                        getDepartment(departmentId, null));

                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    private Employee getManager(Integer managerId, Employee employee){

        if(managerId == null){
            return null;
        }

        try(Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE ID = " + managerId);

            while (resultSet.next()) {

                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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
                        getDepartment(departmentId,null));

                return employee;
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return employee;
    }

    private Employee getEmployee(Integer employee){
        try(Statement statement = connection.createStatement()){
            if(employee == null){
                return null;
            }
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE ID = " + employee);

            while (resultSet.next()) {

                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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
                        getEmployee(manager),
                        getDepartment(departmentId,null));
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        throw new RuntimeException();
    }

    private Department getDepartment(Integer departmentId, Department department){

        if(departmentId == null){
            return null;
        }

        try(Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPARTMENT WHERE ID = " + departmentId);

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
                String name  = resultSet.getObject("NAME", String.class);
                String location  = resultSet.getObject("LOCATION", String.class);

                department = new Department(id,name,location);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return department;
    }

    @Override
    public List<Employee> getAllSortByLastname(Paging paging) {
        return sortByAttribute(paging,"SELECT * FROM EMPLOYEE ORDER BY LASTNAME LIMIT ? OFFSET ?");
    }

    @Override
    public List<Employee> getAllSortBySalary(Paging paging) {
        return sortByAttribute(paging, "SELECT * FROM EMPLOYEE ORDER BY SALARY LIMIT ? OFFSET ?");
    }

    @Override
    public List<Employee> getAllSortByDepartmentNameAndLastname(Paging paging) {
        return sortByAttribute(paging, "SELECT * FROM EMPLOYEE ORDER BY DEPARTMENT, LASTNAME LIMIT ? OFFSET ?");
    }

    @Override
    public List<Employee> getByDepartmentSortByHireDate(Department department, Paging paging) {

        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM EMPLOYEE WHERE DEPARTMENT = " + department.getId() + " ORDER BY HIREDATE LIMIT ? OFFSET ?")) {
            statement.setObject(1, paging.itemPerPage);
            statement.setObject(2, (paging.page-1) * paging.itemPerPage);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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
                        getManager(managerId, null),
                        getDepartment(departmentId, null));

                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }


    @Override
    public List<Employee> getByDepartmentSortBySalary(Department department, Paging paging) {

        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM EMPLOYEE WHERE DEPARTMENT = " + department.getId() + " ORDER BY SALARY LIMIT ? OFFSET ?")) {
            statement.setObject(1, paging.itemPerPage);
            statement.setObject(2, (paging.page-1) * paging.itemPerPage);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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
                        getManager(managerId, null),
                        getDepartment(departmentId, null));

                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> getByDepartmentSortByLastname(Department department, Paging paging) {

        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM EMPLOYEE WHERE DEPARTMENT = " + department.getId() + " ORDER BY LASTNAME LIMIT ? OFFSET ?")) {
            statement.setObject(1, paging.itemPerPage);
            statement.setObject(2, (paging.page-1) * paging.itemPerPage);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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
                        getManager(managerId, null),
                        getDepartment(departmentId, null));

                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> getByManagerSortByLastname(Employee manager, Paging paging) {

        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM EMPLOYEE WHERE MANAGER = " + manager.getId() + " ORDER BY LASTNAME LIMIT ? OFFSET ?")) {
            statement.setObject(1, paging.itemPerPage);
            statement.setObject(2, (paging.page-1) * paging.itemPerPage);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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
                        getManager(managerId, null),
                        getDepartment(departmentId, null));

                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> getByManagerSortByHireDate(Employee manager, Paging paging) {
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM EMPLOYEE WHERE MANAGER = " + manager.getId() + " ORDER BY HIREDATE LIMIT ? OFFSET ?")) {
            statement.setObject(1, paging.itemPerPage);
            statement.setObject(2, (paging.page-1) * paging.itemPerPage);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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
                        getManager(managerId, null),
                        getDepartment(departmentId, null));

                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> getByManagerSortBySalary(Employee manager, Paging paging) {
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM EMPLOYEE WHERE MANAGER = " + manager.getId() + " ORDER BY SALARY LIMIT ? OFFSET ?")) {
            statement.setObject(1, paging.itemPerPage);
            statement.setObject(2, (paging.page-1) * paging.itemPerPage);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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
                        getManager(managerId, null),
                        getDepartment(departmentId, null));

                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee getWithDepartmentAndFullManagerChain(Employee employee) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM EMPLOYEE WHERE ID = " + employee.getId())) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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

                return new Employee(id,fullName, position, localDate, salary,
                        getEmployee(managerId),
                        getDepartment(departmentId, null));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new RuntimeException();
    }

    @Override
    public Employee getTopNthBySalaryByDepartment(int salaryRank, Department department) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM EMPLOYEE WHERE DEPARTMENT = " + department.getId()
        + " ORDER BY SALARY DESC OFFSET " + (salaryRank-1))) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
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

                return new Employee(id,fullName, position, localDate, salary,
                        getManager(managerId,null),
                        getDepartment(departmentId, null));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new RuntimeException();
    }
}
