package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 10. Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями).

public class Task1_10 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
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
			mas[i] = rand.nextInt(20);
		}

	}

	public static void printArray(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static int[] masNew(int[] mas) {
		int j = 0;
		int index = 0;
		for (int i = 0; i < mas.length; i++) {
			if (i % 2 != 0) {
				mas[i] = 0;
			}
		}
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] == 0 && i % 2 != 0) {
				j = j + 1;
			}
		}
		int[] masNew = new int[mas.length - j];
		for (int i = 0; i < mas.length; i++) {
			if (i % 2 == 0) {
				masNew[index] = mas[i];
				index = index + 1;
			}
		}
		return masNew;
	}
}
