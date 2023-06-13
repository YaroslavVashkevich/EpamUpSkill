package com.epam.rd.autocode.dao;

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
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    private Connection connection;


    public EmployeeDaoImpl() {
        try {
            connection = ConnectionSource.instance().createConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Employee> getByDepartment(Department department) {

        List<Employee> employees = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE DEPARTMENT = " + department.getId());

            while (resultSet.next()) {
                employees.add(
                        new Employee(BigInteger.valueOf(resultSet.getObject("ID", Integer.class)),
                                new FullName(
                                        resultSet.getObject("FIRSTNAME", String.class)
                                        , resultSet.getObject("LASTNAME", String.class)
                                        , resultSet.getObject("MIDDLENAME", String.class)
                                ),
                                Position.valueOf(resultSet.getObject("POSITION", String.class)),
                                LocalDate.parse(resultSet.getDate("HIREDATE").toString()),
                                resultSet.getObject("SALARY", BigDecimal.class),
                                BigInteger.valueOf(resultSet.getObject("MANAGER", Integer.class)),
                                BigInteger.valueOf(resultSet.getObject("DEPARTMENT", Integer.class))
                        ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> getByManager(Employee employee) {

        List<Employee> employees = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE MANAGER = " + employee.getId());

            while (resultSet.next()) {
                BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
                FullName fullName = new FullName(
                        resultSet.getObject("FIRSTNAME", String.class)
                        , resultSet.getObject("LASTNAME", String.class)
                        , resultSet.getObject("MIDDLENAME", String.class)
                );
                Position position = Position.valueOf(resultSet.getObject("POSITION", String.class));
                LocalDate localDate = LocalDate.parse(resultSet.getDate("HIREDATE").toString());
                BigDecimal salary =  resultSet.getObject("SALARY", BigDecimal.class);
                Integer managerId = resultSet.getObject("MANAGER", Integer.class);
                Integer departmentId = resultSet.getObject("DEPARTMENT", Integer.class);

                if(managerId == null){
                    managerId = 0;
                }

                if(departmentId == null){
                    departmentId = 0;
                }
                employees.add(new Employee(id, fullName, position,localDate,salary, BigInteger.valueOf(managerId), BigInteger.valueOf(departmentId)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public Optional<Employee> getById(BigInteger Id) {
        Employee employee = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");
            while (resultSet.next()) {
                if (BigInteger.valueOf(resultSet.getInt("ID")).equals(Id)) {
                    BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
                    FullName fullName = new FullName(
                            resultSet.getObject("FIRSTNAME", String.class)
                            , resultSet.getObject("LASTNAME", String.class)
                            , resultSet.getObject("MIDDLENAME", String.class)
                    );
                    Position position = Position.valueOf(resultSet.getObject("POSITION", String.class));
                    LocalDate localDate = LocalDate.parse(resultSet.getDate("HIREDATE").toString());
                    BigDecimal salary =  resultSet.getObject("SALARY", BigDecimal.class);
                    Integer managerId = resultSet.getObject("MANAGER", Integer.class);
                    Integer departmentId = resultSet.getObject("DEPARTMENT", Integer.class);

                    if(managerId == null){
                        managerId = 0;
                    }

                    if(departmentId == null){
                        departmentId = 0;
                    }

                    employee = new Employee(id, fullName, position,localDate,salary, BigInteger.valueOf(managerId), BigInteger.valueOf(departmentId));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.ofNullable(employee);
    }

    @Override
    public List<Employee> getAll() {

        List<Employee> employees = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");

            while (resultSet.next()) {
            BigInteger id = BigInteger.valueOf(resultSet.getObject("ID", Integer.class));
            FullName fullName = new FullName(
                    resultSet.getObject("FIRSTNAME", String.class)
                    , resultSet.getObject("LASTNAME", String.class)
                    , resultSet.getObject("MIDDLENAME", String.class)
            );
            Position position = Position.valueOf(resultSet.getObject("POSITION", String.class));
            LocalDate localDate = LocalDate.parse(resultSet.getDate("HIREDATE").toString());
            BigDecimal salary =  resultSet.getObject("SALARY", BigDecimal.class);
            Integer managerId = resultSet.getObject("MANAGER", Integer.class);
            Integer departmentId = resultSet.getObject("DEPARTMENT", Integer.class);

            if(managerId == null){
                managerId = 0;
            }

            if(departmentId == null){
                departmentId = 0;
            }

            employees.add(new Employee(id, fullName, position,localDate,salary, BigInteger.valueOf(managerId), BigInteger.valueOf(departmentId)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;

    }

    @Override
    public Employee save(Employee employee) {
        try (PreparedStatement st = this.connection.prepareStatement("INSERT INTO EMPLOYEE (ID, FIRSTNAME, LASTNAME" +
                ", MIDDLENAME, POSITION, MANAGER, HIREDATE, SALARY, DEPARTMENT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            if (getById(employee.getId()).isEmpty()) {
                st.setObject(1, employee.getId().intValue());
                st.setObject(2, employee.getFullName().getFirstName());
                st.setObject(3, employee.getFullName().getLastName());
                st.setObject(4, employee.getFullName().getMiddleName());
                st.setObject(5, employee.getPosition().toString());
                st.setObject(6, employee.getManagerId().intValue());
                st.setObject(7, employee.getHired().toString());
                st.setObject(8, employee.getSalary().doubleValue());
                st.setObject(9, employee.getDepartmentId().intValue());
                st.execute();
                return employee;
            } else {
                return updateExisting(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Employee updateExisting(Employee employee){
        try (PreparedStatement st = this.connection.prepareStatement("UPDATE EMPLOYEE SET " +
                "FIRSTNAME = ?, LASTNAME = ?, MIDDLENAME = ?, POSITION = ?, MANAGER = ?, HIREDATE = ?, " +
                "SALARY = ?, DEPARTMENT = ? WHERE ID = " + employee.getId())) {

                st.setString(1, employee.getFullName().getFirstName());
                st.setString(2, employee.getFullName().getLastName());
                st.setString(3, employee.getFullName().getMiddleName());
                st.setString(4, employee.getPosition().toString());
                st.setLong(5, employee.getManagerId().intValue());
                st.setDate(6, Date.valueOf(employee.getHired()));
                st.setDouble(7, employee.getSalary().doubleValue());
                st.setLong(8, employee.getDepartmentId().intValue());
                st.execute();
                return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Employee employee) {
        BigInteger id = employee.getId();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
            statement.setInt(1, id.intValue());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
