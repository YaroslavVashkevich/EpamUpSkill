package com.epam.upskill;

import java.util.Scanner;

//2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте конструктор,
// инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра класса.

public class Main {

    public static void main(String[] args) {
        int a = enterFromConsole("Input number a");
        int b = enterFromConsole("Input number b");
        Test2 test = new Test2(1, 2);
        System.out.println("Number a = " + test.getA() + "  Number b = " + test.getB());
        test.setA(a);
        test.setB(b);
        test.print();

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