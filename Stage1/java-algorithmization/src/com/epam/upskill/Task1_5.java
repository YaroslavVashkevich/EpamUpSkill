package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i. 

public class Task1_5 {

	public static void main(String[] args) {

		int a = enterFromConsole("Input number a");
		int[] mas = new int[a];

		initArray(mas);
		printArray(mas);
		System.out.println();
		System.out.println("Result");
		change(mas);
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

	public static void change(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] > i) {
				System.out.print(mas[i] + " ");
			}
		
		}
		
	}

}