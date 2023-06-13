package com.epam.upskill;

//6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и изменения его
// отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений.
// В случае недопустимых значений полей поле устанавливается в значение 0.
// Создать методы изменения времени на заданное количество часов, минут и секунд.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Time time = new Time();
        int hour = enterFromConsole("Input hour");
        int minute = enterFromConsole("Input minute");
        int second = enterFromConsole("Input second");

        time.setHour(hour);
        time.setMinute(minute);
        time.setSecond(second);
        print(time);
        int changeHour = enterFromConsole("Input change hour");
        int changeMinute = enterFromConsole("Input change minute");
        int changeSecond = enterFromConsole("Input change second");
        time.setChangeHour(changeHour);
        time.setChangeMinute(changeMinute);
        time.setChangeSecond(changeSecond);
        printChange(time);
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

    public static void print(Time time) {
        System.out.println(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
    }

    public static void printChange(Time time) {
        System.out.println(time.getChangeHour() + ":" + time.getChangeMinute() + ":" + time.getChangeSecond());
    }
}
