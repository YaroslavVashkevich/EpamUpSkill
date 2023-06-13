package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 5. Реализуйте сортировку Шелла.

public class Task3_5 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		sortShellMax(mas);
		printArray(mas);
		System.out.println();
		sortShellMin(mas);
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
			mas[i] = rand.nextInt(20);
		}

	}

	public static void printArray(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static void sortShellMax(int[] mas) {
		int x = mas.length / 2;
        while (x >= 1) {
            for (int i = 0; i < mas.length; i++) {
                for (int j = i - x; j >= 0; j = j - x) {
                    if (mas[j] > mas[j + x]) {
                        int tmp = mas[j];
                        mas[j] = mas[j + 1];
                        mas[j + 1] = tmp;
                    }
                }
            }
            x = x / 2;
        }
	}
	public static void sortShellMin(int[] mas) {
		int x = mas.length / 2;
        while (x >= 1) {
            for (int i = 0; i < mas.length; i++) {
                for (int j = i - x; j >= 0; j = j - x) {
                    if (mas[j] < mas[j + x]) {
                        int temp = mas[j];
                        mas[j] = mas[j + 1];
                        mas[j + 1] = temp;
                    }
                }
            }
            x = x / 2;
        }
	}
	
}