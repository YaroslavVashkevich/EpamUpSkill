package com.epam.upskill;

public class Test2 {
    private int a;
    private int b;

    public Test2() {
        a = 3;
        b = 4;
    }

    public Test2(int a, int b) {
        super();
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void print() {
        System.out.println("Number a = " + a + "  Number b = " + b);
    }

}