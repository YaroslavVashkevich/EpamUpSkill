package com.epam.upskill;

import java.util.Scanner;

// 6. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа. m и n вводятся с клавиатуры.

public class Task3_6 {
	public static void main(String[] args) {
		int m = enterFromConsole("Input number begin m");
		int n = enterFromConsole("Input namber end n");
		for (int i = m; i <= n; i++) {
			System.out.print("Divisor of a number " + i + " is ");
			for (int j = 1; i >= j; j++) {
				if (j == 1 || j == i) {
					continue;
				} else if (i % j == 0) {
					System.out.print(j + " ");
				} else {
					continue;
				}

			}
			System.out.println("");
		}
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
