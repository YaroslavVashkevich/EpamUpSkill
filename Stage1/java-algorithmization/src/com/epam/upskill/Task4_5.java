package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

/* 5. ��������� ���������, ������� � ������� A[N] ������� ������ �� �������� ����� 
(������� �� ������ �����, ������� ������ ������������� �������� �������, �� ������ ���� ������ ���������).*/

public class Task4_5 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[] mas = new int[n];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		lessMax(mas);

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

	public static int max(int[] mas) {
		int max = mas[0];
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] > max) {
				max = mas[i];
			}
		}
		return max;
	}
	
	public static void lessMax(int[] mas) {
		int max = max(mas);
		int lessMax = mas[0];
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] > lessMax && mas[i] < max) {
				lessMax = mas[i];
			}
		}
		System.out.println("Element less maximum = " + lessMax);
	}
}