package com.epam.rd.autocode;

import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RowMapperImpl implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet) {
        try {
            Integer id = resultSet.getObject("ID", Integer.class);
            String firstName = resultSet.getObject("FIRSTNAME", String.class);
            String lastName = resultSet.getObject("LASTNAME", String.class);
            String middleName = resultSet.getObject("MIDDLENAME", String.class);
            FullName fullName = new FullName(firstName, lastName, middleName);
            String position = resultSet.getObject("POSITION", String.class);
            LocalDate hired = resultSet.getObject("HIREDATE", LocalDate.class);
            BigDecimal salary = resultSet.getObject("SALARY", BigDecimal.class);
            return new Employee(new BigInteger(id.toString()), fullName, Position.valueOf(position), hired, salary);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
