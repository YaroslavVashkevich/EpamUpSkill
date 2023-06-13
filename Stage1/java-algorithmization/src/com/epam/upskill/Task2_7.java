package com.epam.upskill;

import java.util.Scanner;

// 7. Сформировать квадратную матрицу порядка N по правилу: A[I,J] = sin((I² - J²) / N).

public class Task2_7 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		double[][] mas = new double[n][n];
		System.out.println("Result");
		initArray(mas);
		printArray(mas);
		System.out.println();
		positive(mas);

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

	public static void initArray(double[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / mas.length);

			}
		}
	}

	public static void positive(double[][] mas) {
		int count = 0;
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				if (mas[i][j] > 0) {
					count = count + 1;
				}
			}
		}
		System.out.println("Positive elements " + count);
	}

	public static void printArray(double[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
