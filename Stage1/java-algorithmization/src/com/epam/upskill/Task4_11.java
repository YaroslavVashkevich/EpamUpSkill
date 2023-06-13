package com.epam.upskill;

import java.util.Scanner;

// 11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.

public class Task4_11 {

	public static void main(String[] args) {

		int x = enterFromConsole("Input number x");
		int y = enterFromConsole("Input number y");

		more(x, y);
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

	public static void more(int x, int y) {
		int x1 = String.valueOf(x).length();
        int y1 = String.valueOf(y).length();
        if (x1 > y1) System.out.println("Number X more");
        else if (x1 < y1) System.out.println("Number Y more");
        else {
            System.out.println("Number X = Number Y");
        }
		
	}
}