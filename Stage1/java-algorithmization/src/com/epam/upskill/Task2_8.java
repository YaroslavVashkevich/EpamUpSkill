package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

/* 8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить на соответствующие им позиции другого,
а его элементы второго переместить в первый. Номера столбцов вводит пользователь с клавиатуры.*/

public class Task2_8 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int m = enterFromConsole("Input number m");
		int c1 = enterFromConsole("Input number column 1");
		int c2 = enterFromConsole("Input number column 2");
		int[][] mas = new int[n][m];

		initArray(mas);
		printArray(mas);
		System.out.println("Result");
		change(mas, c1, c2);
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

	public static void change(int[][] mas, int c1, int c2) {	
           for (int i = 0; i < mas.length; i++) {
                int change = mas[i][c1 - 1];
                mas[i][c1 - 1] = mas[i][c2 - 1];
                mas[i][c2 - 1] = change;
            }
	}
}
