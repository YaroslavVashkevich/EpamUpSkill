package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 8. Дана последовательность целых чисел а1 ,а2 ,..., аn. Образовать новую последовательность, выбросив из исходной те члены, которые равны min(а1 ,а2 ,..., аn).

public class Task1_8 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		System.out.println("Min number " + min(mas) + " Quantity " + quant(mas));
		printArray(masNew(mas));
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

	public static int min(int[] mas) {
		int min = mas[0];
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] < min) {
				min = mas[i];
			}
		}
		return min;
	}

	public static int quant(int[] mas) {
		int j = 0;
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] == min(mas)) {
				j = j + 1;
			}
		}
		return j;
	}

	public static int[] masNew(int[] mas) {
		int index = 0;
		int[] masNew = new int[mas.length - quant(mas)];
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] != min(mas)) {
				masNew[index] = mas[i];
				index = index + 1;
			}
		}
		return masNew;
	}
}
