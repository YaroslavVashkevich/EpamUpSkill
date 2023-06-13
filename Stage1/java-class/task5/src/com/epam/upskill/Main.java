package com.epam.upskill;

import java.util.Scanner;

//5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу
// в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями.
// Счетчик имеет методы увеличения и уменьшения состояния, и метод позволяющее получить его текущее состояние.
// Написать код, демонстрирующий все возможности класса.

public class Main {
    public static void main(String args[]) throws Exception {
        Counter counter1 = new Counter(1, 10, 5);
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        print(counter1);
        print(counter2);
        int min = enterFromConsole("Input Min");
        int max = enterFromConsole("Input Max");
        int count = enterFromConsole("Input Count");
        counter3.setMin(min);
        counter3.setMax(max);
        counter3.setCount(count);
        print(counter3);
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

    public static void print(Counter counter) throws Exception {
        System.out.println("Min = " + counter.getMin() + "    Count = " + counter.getCount() + "    Max - " + counter.getMax());
        System.out.print("    Previous = " + counter.getPrevious());
        System.out.println("    Next = " + counter.getNext());

    }
}
