package com.epam.rd.autocode.dao;

import com.epam.rd.autocode.ConnectionSource;
import com.epam.rd.autocode.domain.Department;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentDaoImpl implements DepartmentDao {

    private Connection connection;
    private static final String SELECT_ALL_FROM_DEPARTMENT = "SELECT * FROM DEPARTMENT";
    private static final String INSERT = "INSERT INTO DEPARTMENT (ID, NAME, LOCATION) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE DEPARTMENT SET NAME = ?, LOCATION= ? WHERE ID = ?";
    private static final String DELETE = "DELETE FROM DEPARTMENT WHERE ID = ?";

    public DepartmentDaoImpl() {
        try {
            connection = ConnectionSource.instance().createConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Optional<Department> getById(BigInteger Id) {
        Department department = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_DEPARTMENT);
            while (resultSet.next()) {
                if (BigInteger.valueOf(resultSet.getInt("ID")).equals(Id)) {
                    department = new Department(
                            BigInteger.valueOf(resultSet.getObject("ID", Integer.class)),
                            resultSet.getString("NAME"),
                            resultSet.getString("LOCATION"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.ofNullable(department);
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_DEPARTMENT);
            while (resultSet.next()) {
                departments.add(new Department(
                        BigInteger.valueOf(resultSet.getObject("ID", Integer.class)),
                        resultSet.getString("NAME"),
                        resultSet.getString("LOCATION")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return departments;
    }

    @Override
    public Department save(Department department) {
        try (PreparedStatement st = connection.prepareStatement(INSERT)) {
            if (getById(department.getId()).isEmpty()) {
                st.setLong(1, department.getId().intValue());
                st.setString(2, department.getName());
                st.setString(3, department.getLocation());
                st.execute();
                return null;
            } else
                return updateExisting(department);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Department updateExisting(Department department) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE)) {
            st.setLong(3, department.getId().intValue());
            st.setString(1, department.getName());
            st.setString(2, department.getLocation());
            st.execute();
            return department;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Department department) {
        BigInteger id = department.getId();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, id.intValue());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
