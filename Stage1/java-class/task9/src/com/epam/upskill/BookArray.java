package com.epam.upskill;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class BookArray {
    private Book[] bookArray;

    public BookArray(int size) {
        bookArray = new Book[size];
    }

    public void addBook(Book book) {
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] == null) {
                bookArray[i] = book;
                break;
            }
        }
    }

    public void condition(){
        System.out.println("1 - Author, 2 - Publish, 3 - Year");
        int n = enterFromConsole("Input number: ");
        choice(n, bookArray);
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
    public void choice(int n, Book[] bookArray) {
        switch (n) {
            case 1:
                int author = enterFromConsole("Input number author: 1 - Сергеева Т.М., 2 - Давыдов Б.С., 3 - Колесников П.С., 4 - Кононова Г.А., 5 - Корнилов Г.В.");
                infoAuthor(author, bookArray);
                break;
            case 2:
                int publish = enterFromConsole("Input number publish: 1 - Мир, 2 - Аст, 3 - Азбука, 4 - Феникс, 5 - Фламинго");
                infoPublish(publish, bookArray);
                break;
            case 3:
                int year = enterFromConsole("Input year last: ");
                infoYear(year, bookArray);
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }
    }

    public void infoAuthor(int author, Book[] bookArray) {
        String[] authors = new String[]{"Сергеева Т.М.", "Давыдов Б.С.", "Колесников П.С.", "Кононова Г.А.", "Корнилов Г.В."};
        Arrays.sort(bookArray, Comparator.comparing(Book::getYear));
        if (author < 1 || author > 5) {
            System.out.println("This author is not available.");
        } else {
            for (Book number : bookArray) {
                if (number.getAuthor().equals(authors[author - 1])) {
                    System.out.println(number.toString());
                }
            }
        }

    }

    public void infoPublish(int publish, Book[] bookArray) {
        String[] publishing = new String[]{"Мир", "Аст", "Азбука", "Феникс", "Фламинго"};
        Arrays.sort(bookArray, Comparator.comparing(Book::getYear));
        if (publish < 1 || publish > 5) {
            System.out.println("This publish is not available.");
        } else {
            for (Book number : bookArray) {
                if (number.getPublish().equals(publishing[publish - 1])) {
                    System.out.println(number.toString());
                }
            }
        }
    }

    public void infoYear(int year, Book[] bookArray) {
        Arrays.sort(bookArray, Comparator.comparing(Book::getYear));
        int count = 0;
        if (year <= 0 || year > 2020) {
            System.out.println("This year is not available.");
        } else {
            for (Book number : bookArray) {
                if (number.getYear() > year) {
                    System.out.println(number.toString());
                    count++;
                }
            }
            if (count == 0){
                System.out.println("There are no books after this year.");
            }
        }
    }
}
