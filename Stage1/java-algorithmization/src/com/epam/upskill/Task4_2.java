package com.epam.upskill;

import java.util.Scanner;

// 2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.

public class Task4_2 {

	public static void main(String[] args) {

		int a = enterFromConsole("Input number a");
		int b = enterFromConsole("Input number b");
		int c = enterFromConsole("Input number c");
		int d = enterFromConsole("Input number d");
		int nod = nod(a, b, c, d);
		System.out.println("NOD = " + nod);
		

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

	public static int nod(int a, int b, int c, int d) {
		int min = Math.min(Math.min(a, b), Math.min(c, d));
		for (int i = min; i > 1; i--) {
			if (a % i == 0 && b % i == 0 && c % i == 0 && d % i == 0) {
				return i;
			}
		}
		return 1;

	}


}
