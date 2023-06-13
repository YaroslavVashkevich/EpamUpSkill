package com.epam.rd.autocode;

import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;

public class EmployeeRecord {
    private final BigInteger id;
    private final FullName fullName;
    private final Position position;
    private final LocalDate hired;
    private final BigDecimal salary;
    private final Integer manager;

    public EmployeeRecord(final BigInteger id, final FullName fullName,
                          final Position position, final LocalDate hired,
                          final BigDecimal salary, final Integer manager) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.hired = hired;
        this.salary = salary.setScale(5, RoundingMode.HALF_UP);
        this.manager = manager;
    }

    public BigInteger getId() {
        return id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public Position getPosition() {
        return position;
    }

    public LocalDate getHired() {
        return hired;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Integer getManager() {
        return manager;
    }
}
