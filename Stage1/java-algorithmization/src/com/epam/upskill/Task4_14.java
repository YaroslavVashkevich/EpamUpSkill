package com.epam.upskill;

import java.util.Scanner;

/*14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, возведенная в степень n, равна самому числу.
      Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.*/

public class Task4_14 {
	public static void main(String[] args) {

		int k = enterFromConsole("Input number k");

		for (int i = 1; i <= k; i++) {
			if (armstrong(i)) {
				System.out.print(i + " ");
			}
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

	public static boolean armstrong(int i) {

		int count = count(i);
		int value = 0;
		int number = i;

		for (int j = 0; j < count; j++) {
			value = value + (int) (Math.pow((i % 10), count));
			i = i / 10;
		}
		return value == number;
	}

	public static int count(int i) {

		int count = 0;
		while (i != 0) {
			count++;
			i = i / 10;
		}
		return count;
	}
}
