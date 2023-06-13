package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких чисел несколько, то определить наименьшее из них.

public class Task1_9 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println("\n" +"Result");
		int[] oftenNumber = oftenNumber(mas);
		int max = maxNumber(oftenNumber);
		if (oftenNumber[max] == 1) {
			System.out.println("Numbers are not repeated");
		} else {
			System.out.println("Often a number = " + mas[maxNumber(oftenNumber)]);
		}
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

	public static int[] oftenNumber(int[] mas) {
		int count = 0;
		int[] oftenNumber = new int[mas.length];
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length; j++) {
				if (mas[i] == mas[j]) {
					count = count + 1;
					oftenNumber[i] = count;
				}

			}
			count = 0;

		}

		return oftenNumber;
	}

	public static int maxNumber(int[] oftenNumber) {
		int s = 0;
		int max = oftenNumber[0];
		for (int i = 1; i < oftenNumber.length; i++) {
			if (oftenNumber[i] > max) {
				max = oftenNumber[i];
				s = i;
			}
		}
		return s;
	}
}
