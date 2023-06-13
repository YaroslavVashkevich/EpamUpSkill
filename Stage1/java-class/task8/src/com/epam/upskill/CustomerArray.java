package com.epam.upskill;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class CustomerArray {
    private Customer[] customerArray;

    public CustomerArray(int size) {
        customerArray = new Customer[size];
    }

    public void addCustomer(Customer customer) {
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i] == null) {
                customerArray[i] = customer;
                break;
            }
        }
    }

    public void condition() {
        System.out.println("1 - Customer, 2 - BankCard");
        int n = enterFromConsole("Input number: ");
        choice(n, customerArray);
    }

    public int enterFromConsole(String message) {
        Scanner sc = new Scanner(System.in);
        int value;
        System.out.println(message);
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.println(message);
        }
        value = sc.nextInt();
        return value;
    }

    public void choice(int n, Customer[] customerArray) {
        switch (n) {
            case 1:
                infoCustomer(customerArray);
                break;
            case 2:
                System.out.println("Input first number bankCard:");
                long firstBankcard = new Scanner(System.in).nextLong();
                System.out.println("Input last number bankCard:");
                long lastBankcard = new Scanner(System.in).nextLong();
                infoBankcard(firstBankcard, lastBankcard, customerArray);
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }
    }

    public void infoCustomer(Customer[] customerArray) {
        Arrays.sort(customerArray, Comparator.comparing(Customer::getSurname));
        for (Customer number : customerArray) {
            System.out.println(number.toString());
        }
    }

    public void infoBankcard(long firstBankcard, long lastBankcard, Customer[] customerArray) {
        Arrays.sort(customerArray, Comparator.comparing(Customer::getBankcard));
        for (Customer number : customerArray) {
            if (number.getBankcard() >= firstBankcard && number.getBankcard() <= lastBankcard || number.getBankcard() <= firstBankcard && number.getBankcard() >= lastBankcard) {
                System.out.println(number.toString());
            }
        }
    }
}