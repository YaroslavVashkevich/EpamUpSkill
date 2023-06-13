package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 3. ƒан массив действительных чисел, размерность которого N. ѕодсчитать, сколько в нем отрицательных, положительных и нулевых элементов.

public class Task1_3 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		posNeg(mas);
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

	public static void posNeg(int[] mas) {
		int neg, pos, zer;
		neg = 0;
		pos = 0;
		zer = 0;
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] < 0) {
				neg = neg + 1;
			} else
			if (mas[i] > 0) {
				pos = pos + 1;
			} else
			if (mas[i] == 0) {
				zer = zer + 1;
			}

		}
		System.out.print("Positive = " + pos + " Negative = " + neg + " Zerro = " + zer);
	}

}