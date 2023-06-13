package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 4. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.

public class Task1_4 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		minMax(mas);
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

	public static void initArray(int[] mas) {
		Random rand = new Random();
		for (int i = 0; i < mas.length; i++) {
			int x = rand.nextInt(20);
			mas[i] = x - 5;
		}

	}

	public static void printArray(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static void minMax(int[] mas) {
		int maxI = 0;
		int minI = 0;
		int max = mas[0];
		int min = mas[0];
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] > max) {
				max = mas[i];
				maxI = i;
			}
			if (mas[i] < min) {
				min = mas[i];
				minI = i;
			}

		}
		mas[maxI] = min;
		mas[minI] = max;
		System.out.println("MIN = " + min + " MAX = " + max);
	}

}
