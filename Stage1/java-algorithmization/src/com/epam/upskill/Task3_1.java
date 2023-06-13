package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

/* 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя дополнительный массив.*/

public class Task3_1 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input Mas1 ");
		int m = enterFromConsole("Input Mas2 ");
		int k = enterFromConsole("Input number K");
		int[] mas1 = new int[n];
		int[] mas2 = new int[m];

		initArray(mas1);
		initArray(mas2);
		printArray(mas1);
		printArray(mas2);
		System.out.println("Result");
		join(mas1, mas2, k);
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

	public static void initArray(int[] mas) {
		Random rand = new Random();
		for (int i = 0; i < mas.length; i++) {
			mas[i] = rand.nextInt(10);
		}
	}

	public static void printArray(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + "  ");
		}
		System.out.println();
	}

	public static void join(int[] mas1, int[] mas2, int k) {
		mas1 = Arrays.copyOf(mas1, mas1.length + mas2.length);

		for (int i = mas1.length - mas2.length - 1; i >= k; i--) {
			mas1[mas2.length + i] = mas1[i];
		}
		for (int i = 0; i < mas2.length; i++) {
			mas1[k + i] = mas2[i];
		}
		System.out.println(Arrays.toString(mas1));
	}

}
