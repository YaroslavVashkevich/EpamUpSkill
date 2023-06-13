package com.epam.upskill;

import java.util.Scanner;

// 4. Составить программу нахождения произведения квадратов первых двухсот чисел.

public class Task3_4 {
	public static void main(String[] args) {
		int x = enterFromConsole("Input number x");
		long sum = 1;
		
		for (int i = 1; i <= x; i++) {	
			sum = sum * (i * i);
			if (sum > Integer.MAX_VALUE) {
				System.out.println("Range overflow Integer!!!");
				break;
			}
			System.out.println(i + "  " + sum);
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
}
