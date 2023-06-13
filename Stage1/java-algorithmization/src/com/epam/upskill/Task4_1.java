package com.epam.upskill;

import java.util.Scanner;

// 1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух натуральных чисел: HOK(A,B) = (A*B)/ НОД(A,B).

public class Task4_1 {

	public static void main(String[] args) {

		int a = enterFromConsole("Input number a");
		int b = enterFromConsole("Input number b");
		int nod = nod(a, b);
		int nok = nok(a, b);
		System.out.println("NOD = " + nod);
		System.out.println("NOK = " + nok);

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

	public static int nod(int a, int b) {
		for (int i = (a > b ? b : a); i > 1; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 1;

	}

	public static int nok(int a, int b) {
		int nok = (a * b) / nod(a, b);
		return nok;
	}

}
