package com.epam.upskill;

import java.util.Scanner;

// 3. Найти сумму квадратов первых ста чисел.

public class Task3_3 {
	public static void main(String[] args) {
		int x = enterFromConsole("Input number x");
		int sum = 0;
		for (int i = 1; i <= x; i++) {
			sum = sum + i*i;
		}

		System.out.printf("Sum = " + sum);
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
