package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 2. Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим числом. Подсчи­тать количество замен.

public class Task1_2 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int z = enterFromConsole("Input number z");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		change(mas, z);
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
			mas[i] = rand.nextInt(20);
		}

	}

	public static void printArray(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static void change(int[] mas, int z) {
		int j = 0;
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] > z) {
				mas[i] = z;
				j = j + 1;
			}
			System.out.print(mas[i] + " ");
		}
		System.out.println();
		System.out.print("Change = " + j);
	}

}