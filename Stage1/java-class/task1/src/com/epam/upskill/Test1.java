package com.epam.upskill;

public class Test1 {
    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void printA() {
        System.out.println("Number a = " + a);
    }

    public void printB() {
        System.out.println("Number b = " + b);
    }

    public void sum() {
        int sum = a + b;
        System.out.println("Sum = " + sum);
    }

    public void max() {
        int max = Math.max(a, b);
        System.out.println("Max = " + max);
    }

}
