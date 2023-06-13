package com.epam.upskill;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

//4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
// Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по номерам
// поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
// Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами назначения
// должны быть упорядочены по времени отправления.

public class Main {
    public static void main(String[] args) {
        Train[] travel = new Train[5];
        travel[0] = new Train("Mogilev", 4, "18:45");
        travel[1] = new Train("Minsk", 1, "10:10");
        travel[2] = new Train("Brest", 2, "12:00");
        travel[3] = new Train("Mogilev", 5, "12:35");
        travel[4] = new Train("Gomel", 3, "22:10");

        System.out.println("1 - Number train, 2 - Sort train, 3 - Sort city");
        int n = enterFromConsole("Input number ");
        choice(n, travel);
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

    public static void choice(int n, Train[] travel) {
        switch (n) {
            case 1:
                int train = enterFromConsole("Input number train from 1 to 5.");
                info(train, travel);
                break;
            case 2:
                sortTrain(travel);
                break;
            case 3:
                sortCity(travel);
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }

    }

    public static void info(int train, Train[] travel) {
        int count = 0;
        for (Train number : travel) {
            if (number.getTrain() == train) {
                System.out.println("Train number " + number.getTrain() + " " + number.getCity() + " " + number.getTime());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("This number is not available.");
        }
    }

    public static void sortTrain(Train[] travel) {
        Arrays.sort(travel, Comparator.comparing(Train::getTrain));
        for (Train number : travel) {
            System.out.println("Train number " + number.getTrain() + " " + number.getCity() + " " + number.getTime());

        }
    }

    public static void sortCity(Train[] travel) {
        Arrays.sort(travel, Comparator.comparing(Train::getCity).thenComparing(Train::getTime));
        for (Train number : travel) {
            System.out.println("Train number " + number.getTrain() + " " + number.getCity() + " " + number.getTime());

        }
    }
}