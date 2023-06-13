package com.epam.upskill;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class AirlineArray {

    private Airline[] airlineArray;

    public AirlineArray(int size) {
        this.airlineArray = new Airline[size];
    }

    public void addAirLine(Airline airline) {
        for (int i = 0; i < airlineArray.length; i++) {
            if (airlineArray[i] == null) {
                airlineArray[i] = airline;
                break;
            }
        }
    }

    public void condition() {
        System.out.println("1 - City, 2 - Weekday, 3 - Weekday,time");
        int n = enterFromConsole("Input number: ");
        choice(n, airlineArray);
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

    public void choice(int n, Airline[] airlineArray) {
        switch (n) {
            case 1:
                int city = enterFromConsole("Input number city: 1 - Minsk, 2 - Moscow, 3 - Berlin, 4 - Kiev, 5 - Warsaw, 6 - Paris");
                infoCity(city, airlineArray);
                break;
            case 2:
                int weekday = enterFromConsole("Input number weekday: 1 - Monday, 2 - Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday, 7 - Sunday");
                infoWeekday(weekday, airlineArray);
                break;
            case 3:
                int weekdayTime = enterFromConsole("Input number weekday: 1 - Monday, 2 - Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday, 7 - Sunday");
                System.out.println("Input time: hour.min");
                String time = new Scanner(System.in).next();
                infoWeekdayTime(weekdayTime, time, airlineArray);
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }

    }

    public void infoCity(int city, Airline[] airlineArray) {
        String[] place = new String[]{"Minsk", "Moscow", "Berlin", "Kiev", "Warsaw", "Paris"};
        Arrays.sort(airlineArray, Comparator.comparing(Airline::getTime));
        if (city < 1 || city > 6) {
            System.out.println("This city is not available.");
        } else {
            for (Airline number : airlineArray) {
                if (number.getCity().equals(place[city - 1])) {
                    System.out.println(number.toString());
                }
            }
        }

    }

    public void infoWeekday(int weekday, Airline[] airlineArray) {
        String[] date = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Arrays.sort(airlineArray, Comparator.comparing(Airline::getTime));
        if (weekday < 1 || weekday > 7) {
            System.out.println("This weekday is not available.");
        } else {
            for (Airline number : airlineArray) {
                if (number.getWeekday().equals(date[weekday - 1])) {
                    System.out.println(number.toString());
                }
            }
        }
    }

    public void infoWeekdayTime(int weekdayTime, String time, Airline[] airlineArray) {
        String[] date = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Arrays.sort(airlineArray, Comparator.comparing(Airline::getTime));
        if (weekdayTime < 1 || weekdayTime > 7) {
            System.out.println("This weekday is not available.");
        } else {
            for (Airline number : airlineArray) {
                if (number.getWeekday().equals(date[weekdayTime - 1]) && Double.parseDouble(number.getTime()) > Double.parseDouble(time)) {
                    System.out.println(number.toString());
                }
            }
        }
    }
}