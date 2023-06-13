package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.

public class Task2_2 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int m = enterFromConsole("Input number m");
		int[][] mas = new int[n][m];

		initArray(mas);
		printArray(mas);
		System.out.println("Result");
		diag(mas);

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

	public static void diag(int[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i][i] + " ");
		}
		System.out.println();
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[mas.length - 1 - i][i] + " ");
		}

	}
}
