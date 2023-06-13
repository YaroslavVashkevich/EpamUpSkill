package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 6. «адана последовательность N вещественных чисел. ¬ычислить сумму чисел, пор€дковые номера которых €вл€ютс€ простыми числами.  

public class Task1_6 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		double[] mas = new double[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		simple(mas);
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

	public static void simple(double[] mas) {
		double sum = 0.0;

		for (int i = 2; i < mas.length; i++) {
			for (int j = 2; j <= i; j++) {
				if (i % j == 0 && i != j) {
					break;
				} else if (i % j == 0 && i == j) {
					sum = sum + mas[i];
				}

			}

		}
		System.out.println("Sum = " + sum);
	}

}