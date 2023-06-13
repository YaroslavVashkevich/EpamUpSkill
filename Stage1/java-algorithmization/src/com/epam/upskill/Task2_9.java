package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой столбец содержит максимальную сумму.

public class Task2_9 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int m = enterFromConsole("Input number m");
		int[][] mas = new int[n][m];

		initArray(mas);
		printArray(mas);
		System.out.println("Result");
		sum(mas);
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

	public static void initArray(int[][] mas) {
		Random rand = new Random();
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = rand.nextInt(10);
			}
		}
	}

	public static void printArray(int[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void sum(int[][] mas) {
		int sum = 0;
		int[] max = new int[mas[0].length];
		for (int j = 0; j < mas[0].length; j++) {
			for (int i = 0; i < mas.length; i++) {
				sum = sum + mas[i][j];
			}
			max[j] = sum;
			sum = 0;
		}
		for (int s : max) {
			System.out.print(s + " ");
		}
		int maxI = 0;
		int max1 = max[0];
		for (int i = 1; i < max.length; i++) {
			if (max[i] > max1) {
				max1 = max[i];
				maxI = i;
			}
		}
		System.out.println("\n" + "MAX = " + max1 + " Column № " + maxI);
	}
}
