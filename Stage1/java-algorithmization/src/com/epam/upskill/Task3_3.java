package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 3. Реализуйте сортировку обменами.

public class Task3_3 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		sortExchangeMax(mas);
		printArray(mas);
		System.out.println();
		sortExchangeMin(mas);
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

	public static void sortExchangeMax(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length - 1; j++) {
				if (mas[j] > mas[j + 1]) {
					int temp = mas[j];
					mas[j] = mas[j + 1];
					mas[j + 1] = temp;
				}
			}

		}
	}

	public static void sortExchangeMin(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length - 1; j++) {
				if (mas[j] < mas[j + 1]) {
					int temp = mas[j];
					mas[j] = mas[j + 1];
					mas[j + 1] = temp;
				}
			}

		}
	}

}