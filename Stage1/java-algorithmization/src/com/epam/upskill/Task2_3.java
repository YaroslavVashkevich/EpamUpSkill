package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы. 

public class Task2_3 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int m = enterFromConsole("Input number m");
		int k = enterFromConsole("Input number line k");
		int p = enterFromConsole("Input number column p");
		int[][] mas = new int[n][m];

		initArray(mas);
		printArray(mas);
		System.out.println("Result");
		line(mas, k, p);

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

	public static void line(int[][] mas, int k, int p) {
		int i = 0;
		int j = 0;
		System.out.print("Line K  ");
		while (i < mas[0].length) {
			System.out.print(mas[k-1][i] + " ");
			i++;
		}
		System.out.println();
		System.out.print("Column P  ");
		while (j < mas.length) {
			System.out.print(mas[j][p-1] + " ");
			j++;
		}
		

	}
}
