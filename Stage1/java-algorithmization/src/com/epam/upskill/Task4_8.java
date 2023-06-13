package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

/* 8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов массива с номерами от k до m.*/

public class Task4_8 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int k = enterFromConsole("Input number k");
		int m = enterFromConsole("Input number m");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		sum(mas, k, m);

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

	public static void initArray(int[] mas) {
		Random rand = new Random();
		for (int i = 0; i < mas.length; i++) {
			mas[i] = rand.nextInt(10);
		}

	}

	public static void printArray(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static void sum(int[] mas, int k, int m) {
		int max = 0;
		if (k >= 1 && k <= (mas.length - 2) && k < m && (m - k) == 2) {
			for (int i = k - 1; i <= m - 1; i++) {
				max = max + mas[i];
			}
			System.out.print(max);
		} else {
			System.out.print("Error!!!");
		}
	}

}