package com.epam.upskill;

import java.util.Scanner;

// 2. Найти max{min(a, b), min(c, d)}.

public class Task2_2 {

	public static void main(String[] args) {
		double a = enterFromConsole("Input number a");
		double b = enterFromConsole("Input namber b");
		double c = enterFromConsole("Input namber c");
		double d = enterFromConsole("Input namber d");
		double max = Math.max(Math.min(a, b), Math.min(c, d));
		System.out.println("MAX = " + max);

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