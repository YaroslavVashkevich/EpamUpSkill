package com.epam.upskill;

import java.util.Scanner;

// 7. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.

public class Task3_7 {
	public static void main(String[] args) {
		int x = enterFromConsole("Input number x");
		int y = enterFromConsole("Input number y");
		
		int xx = x;
		int yy = y;
		
		while (xx > 0) {
			int x1 = xx % 10;
			xx = xx / 10;
			while (yy > 0) {
				if ((yy % 10) == x1) {
					System.out.println("Number " + x1 + " is in both digits.");
				}
				yy = yy / 10;
			}
			yy = y;
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
