package com.epam.rd.autocode;

import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SetMapperImpl implements SetMapper<Set<Employee>> {
    @Override
    public Set<Employee> mapSet(ResultSet resultSet) {
        try {
            Map<Integer, EmployeeRecord> employees = new LinkedHashMap<>();
            while (resultSet.next()) {
                Integer id = resultSet.getObject("ID", Integer.class);
                String firstName = resultSet.getObject("FIRSTNAME", String.class);
                String lastName = resultSet.getObject("LASTNAME", String.class);
                String middleName = resultSet.getObject("MIDDLENAME", String.class);
                FullName fullName = new FullName(firstName, lastName, middleName);
                String position = resultSet.getObject("POSITION", String.class);
                LocalDate hired = resultSet.getObject("HIREDATE", LocalDate.class);
                BigDecimal salary = resultSet.getObject("SALARY", BigDecimal.class);
                Integer managerID = resultSet.getObject("MANAGER", Integer.class);
                employees.put(id, new EmployeeRecord(new BigInteger(id.toString()),
                        fullName, Position.valueOf(position), hired, salary, managerID));
            }
            
            return getManager(employees);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Set<Employee> getManager(Map<Integer, EmployeeRecord> map) {
        Set<Employee> employeeHashSet = new HashSet<>();
        for (Map.Entry<Integer, EmployeeRecord> entry : map.entrySet()) {
            EmployeeRecord rec = entry.getValue();
            employeeHashSet.add(new Employee(rec.getId(), rec.getFullName(),
                    rec.getPosition(), rec.getHired(), rec.getSalary(), setManager(rec.getManager(), map)));
        }
        return employeeHashSet;
    }

    private Employee setManager(Integer rec, Map<Integer, EmployeeRecord> employeeRecordMap) {
        EmployeeRecord eRec = employeeRecordMap.get(rec);
        if (eRec == null) {
            return null;
        }
        return new Employee(eRec.getId(), eRec.getFullName(), eRec.getPosition(), eRec.getHired(),
                eRec.getSalary(), setManager(eRec.getManager(), employeeRecordMap));
    }
}
