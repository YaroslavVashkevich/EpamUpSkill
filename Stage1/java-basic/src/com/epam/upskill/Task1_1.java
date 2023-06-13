package com.epam.upskill;

import java.util.Scanner;

// 1. Найдите  значение функции: z = ( (a – 3 ) * b / 2) + c.

public class Task1_1 {

	public static void main(String[] args) {
		double a = enterFromConsole("Input number a");
		double b = enterFromConsole("Input namber b");
		double c = enterFromConsole("Input namber c");
		double z = ((a - 3) * b / 2) + c;
		System.out.println("Z = " + z);

	}

	public static double enterFromConsole(String message) {
		Scanner sc = new Scanner(System.in);
		double value;
		System.out.println(message);
		while (!sc.hasNextDouble()) {
			sc.nextLine();
			System.out.println(message);
		}
		value = sc.nextDouble();
		return value;

	}

}
