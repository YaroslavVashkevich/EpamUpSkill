package com.epam.upskill;

//7.  Ќаписать метод(методы) дл€ вычислени€ суммы факториалов всех нечетных чисел от 1 до 9.

public class Task4_7 {

    public static void main(String[] args) {
        System.out.print("Sum factorials = " + sumFact());
    }

    public static int sumFact() {
        int value = 0;
        for (int i = 1; i < 10; i++) {
            if (i % 2 != 0) {
                value = value + fact(i);
            }
        }
        return value;
    }

    public static int fact(int a) {
        int value = 1;
        for (int i = 1; i <= a; i++) {
            value = value*i;
        }
        return value;
    }
}