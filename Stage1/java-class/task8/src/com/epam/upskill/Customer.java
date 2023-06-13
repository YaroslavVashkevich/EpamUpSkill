package com.epam.upskill;

public class Customer {
    private int id;
    private String surname;
    private String name;
    private String middle;
    private String address;
    private long bankcard;
    private long bankaccount;

    public Customer(int id, String surname, String name, String middle, String address, long bankcard, long bankaccount) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middle = middle;
        this.address = address;
        this.bankcard = bankcard;
        this.bankaccount = bankaccount;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddle() {
        return middle;
    }

    public String getAddress() {
        return address;
    }

    public long getBankcard() {
        return bankcard;
    }

    public long getBankaccount() {
        return bankaccount;
    }

    @Override
    public String toString() {
        return "Customer ID " + id +
                "    " + surname  +
                " " + name +
                " " + middle +
                "    " + address  +
                "    bankСard № " + bankcard +
                "    bankAccount № " + bankaccount;
    }
}
