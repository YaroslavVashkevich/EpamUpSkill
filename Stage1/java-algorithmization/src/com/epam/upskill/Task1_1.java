package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.

public class Task1_1 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int k = enterFromConsole("Input number k");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		sumKrat(mas, k);
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

	public static void sumKrat(int[] mas, int k) {
		int sum = 0;
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] % k == 0) {
				sum = sum + mas[i];
			}
		}
		System.out.print("Sum = " + sum);
	}

}