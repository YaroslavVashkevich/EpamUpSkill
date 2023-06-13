package com.epam.upskill;

import java.util.Scanner;

public class Client {
    private Trip trip;

    public Client() {

        Suggestion suggestion = new Suggestion();

        System.out.println("Меню: 1 - Готовые путевки; 2 - Сортировка по цене; 3 - Выбор путевки; 4 - Выход");

        int run = 0;
        while (true) {
            System.out.print("Введите необходимый пункт меню: ");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    suggestion.printTrips();
                    break;
                case 2:
                    suggestion.sort();
                    break;
                case 3:
                    trip = suggestion.selection();
                    break;
                case 4:
                    run = 1;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
            }
            if (run == 1) {
                break;
            }
        }
    }

    public Trip getTrip() {
        return trip;
    }
}
