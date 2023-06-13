package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.

public class Task2_15 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int m = enterFromConsole("Input number m");
		int[][] mas = new int[n][m];

		initArray(mas);
		printArray(mas);
		System.out.println("Result");
		most(mas);
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
	public static void most(int[][] mas) {
		int max = mas[0][0];
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				if(mas[i][j] > max) {
					max = mas[i][j];
				}	
			}
		}
		System.out.println("Max number = " + max);
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				if(mas[i][j] % 2 != 0) {
					mas[i][j] = max;
				}	
			}
		}
	}
	
	
}
