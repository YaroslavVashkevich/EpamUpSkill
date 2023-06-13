package com.epam.upskill;

import java.util.Scanner;

// 6. ������������ ���������� ������� ������� n �� ��������� �������(n - ������):

public class Task2_6 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[][] mas = new int[n][n];
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

	public static void initArray(int[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = i; j < mas[i].length - i; j++) {
				mas[i][j] = 1;
				mas[mas.length - 1 - i][j] = 1;
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

}
