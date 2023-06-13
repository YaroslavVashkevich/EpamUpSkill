package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 7. Даны действительные числа а1 ,а2 ,..., аn. Найти max(a₁ + a₂ₙ ,a₂ + a₂ₙ₋₁,..., aₙ + aₙ₊₁).

public class Task1_7 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		double[] mas = new double[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		sumMax(mas);
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

	public static void initArray(double[] mas) {
		Random rand = new Random();
		for (int i = 0; i < mas.length; i++) {
			int x = rand.nextInt(40);
			mas[i] = x / 2.5;
		}

	}

	public static void printArray(double[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static void sumMax(double[] mas) {
		double sumMax = 0;
		double sum1 = mas[0] + mas[mas.length - 1];
		for (int i = 1; i < mas.length / 2; i++) {
			double sum2 = mas[i] + mas[mas.length - i - 1];
			sumMax = Math.max(sum1, sum2);
		}
		System.out.println(sumMax);
	}

}