package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 13. Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов.

public class Task2_13 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int m = enterFromConsole("Input number m");
		int[][] mas = new int[n][m];

		initArray(mas);
		printArray(mas);
		System.out.println("Result Max");
		sortMax(mas);
		printArray(mas);
		sortMin(mas);
		System.out.println("Result Min");
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

	public static void initArray(int[][] mas) {
		Random rand = new Random();
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = rand.nextInt(20);
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

	public static void sortMax(int[][] mas) {
		for (int i = 0; i < mas[0].length; i++) {
			for (int j = 0; j < mas.length; j++) {
				for (int c = j + 1; c < mas.length; c++) {
					if (mas[j][i] > mas[c][i]) {
						int max = mas[j][i];
						mas[j][i] = mas[c][i];
						mas[c][i] = max;
					}
				}

			}

		}
	}

	public static void sortMin(int[][] mas) {
		for (int i = 0; i < mas[0].length; i++) {
			for (int j = 0; j < mas.length; j++) {
				for (int c = j + 1; c < mas.length; c++) {
					if (mas[j][i] < mas[c][i]) {
						int max = mas[j][i];
						mas[j][i] = mas[c][i];
						mas[c][i] = max;
					}
				}

			}

		}
	} 

}
