package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 2. Ğåàëèçóéòå ñîğòèğîâêó âûáîğîì.

public class Task3_2 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		sortÑhoiceMax(mas);
		printArray(mas);
		System.out.println();
		sortÑhoiceMin(mas);
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
			mas[i] = rand.nextInt(15);
		}

	}

	public static void printArray(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static void sortÑhoiceMax(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			int minI = i;
			for (int j = i; j < mas.length; j++) {
				if (mas[j] < mas[minI]) {
					minI = j;
				}
			}
			int temp = mas[i];
			mas[i] = mas[minI];
			mas[minI] = temp;
		}
	}

	public static void sortÑhoiceMin(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			int maxI = i;
			for (int j = i; j < mas.length; j++) {
				if (mas[j] > mas[maxI]) {
					maxI = j;
				}
			}
			int temp = mas[i];
			mas[i] = mas[maxI];
			mas[maxI] = temp;
		}
	}

}