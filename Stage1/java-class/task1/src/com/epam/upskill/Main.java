package com.epam.upskill;

import java.util.Scanner;

// 1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных.
// Добавьте метод, который находит сумму значений этих переменных, и метод, который находит наибольшее значение
// из этих двух переменных.

public class Main {

    public static void main(String[] args) {
        int a = enterFromConsole("Input number a");
        int b = enterFromConsole("Input number b");
        Test1 test = new Test1();
        test.setA(a);
        test.setB(b);
        test.printA();
        test.sum();
        test.max();
    }

    public static int enterFromConsole(String message) {
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
}
