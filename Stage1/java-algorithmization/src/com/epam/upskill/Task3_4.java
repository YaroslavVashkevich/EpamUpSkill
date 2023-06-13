package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 4. Реализуйте сортировку вставками.

public class Task3_4 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		sortInsertMax(mas);
		printArray(mas);
		System.out.println();
		sortInsertMin(mas);
		printArray(mas);
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
			System.out.print(mas[i] + " ");
		}
	}

	public static void sortInsertMax(int[] mas) {
		for (int i = 1; i < mas.length; i++) {
			int x = mas[i];
			int y = i - 1;
			while (y >= 0 && mas[y] > x) {
				mas[y + 1] = mas[y];
				mas[y] = x;
				y--;
			}
		}
	}

	public static void sortInsertMin(int[] mas) {
		for (int i = 1; i < mas.length; i++) {
			int x = mas[i];
			int y = i - 1;
			while (y >= 0 && mas[y] < x) {
				mas[y + 1] = mas[y];
				mas[y] = x;
				y--;
			}
		}
	}
}