package com.epam.upskill;

import java.util.Arrays;
import java.util.Scanner;

/*12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
элементами которого являются числа, сумма цифр которых равна К и которые не большее N.*/

public class Task4_12 {

	public static void main(String[] args) {

		int k = enterFromConsole("Input number k");
		int n = enterFromConsole("Input number n");
		System.out.println(Arrays.toString(result(k, n)));
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

	public static int[] result(int k, int n) {
		if (k == 0) {
			return new int[] { 0 };
		}
		int[] mas = new int[k];
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (sum(i) == k) {
				if (j == mas.length - 1) {
					mas = increase(mas);
				}
				mas[j] = i;
				j++;
			}
		}
		return reduce(mas);
	}

	public static int sum(int i) {
		int sum = 0;
		while (i > 0) {
			sum = sum + (i % 10);
			i = i / 10;
		}
		return sum;
	}

	public static int[] increase(int[] mas) {
		int length = mas.length * 2 + 1;
		return (copy(mas, length));
	}

	public static int[] reduce(int[] mas) {
		int length = mas.length - 1;
		while (mas[length] == 0)
			length--;
		return (copy(mas, length));
	}

	public static int[] copy(int[] mas, int length) {
		int[] newMas = new int[length];

		if (mas.length < length) {
			System.arraycopy(mas, 0, newMas, 0, mas.length);
		} else {
			System.arraycopy(mas, 0, newMas, 0, length);
		}
		return newMas;
	}
}