package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.

public class Task2_11 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int m = enterFromConsole("Input number m");
		int[][] mas = new int[n][m];

		initArray(mas);
		printArray(mas);
		System.out.println("Result");
		oftenNumber(mas);

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
				mas[i][j] = rand.nextInt(15);
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

	public static void oftenNumber(int[][] mas) {
		int counter = 0;
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				if (mas[i][j] == 5) {
					counter = counter + 1;
				}
			}
			if (counter >= 3) {
				System.out.println("Line  № " + (i + 1));
			}
			counter = 0;
		}
	}

}
