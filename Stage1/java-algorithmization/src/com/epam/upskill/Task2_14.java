package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 14. —формировать случайную матрицу m x n, состо€щую из нулей и единиц, причем в каждом столбце число единиц равно номеру столбца.

public class Task2_14 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int m = enterFromConsole("Input number m");
		int[][] mas = new int[n][m];

		System.out.println("Result");
		initArray(mas);
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

	public static void printArray(int[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void initArray(int[][] mas) {

		for (int i = 0; i < mas[0].length; i++) {
			int count = 0;
			for (int j = 0; j < mas.length; j++) {
				if (i != 0 && count <= i - 1) {
					mas[j][i] = 1;
					count++;
				} else {
					mas[j][i] = 0;
				}

			}

		}
	}

}
