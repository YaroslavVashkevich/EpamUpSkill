package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.

public class Task2_12 {

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
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				for (int c = j + 1; c < mas[i].length; c++) {
					if (mas[i][j] > mas[i][c]) {
						int max = mas[i][j];
						mas[i][j] = mas[i][c];
						mas[i][c] = max;
					}
				}

			}

		}
	}

	public static void sortMin(int[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				for (int c = j + 1; c < mas[i].length; c++) {
					if (mas[i][j] < mas[i][c]) {
						int max = mas[i][j];
						mas[i][j] = mas[i][c];
						mas[i][c] = max;
					}
				}

			}

		}
	}

}
