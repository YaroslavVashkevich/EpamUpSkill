package com.epam.upskill;

import java.util.Scanner;

/* 6. ƒл€ данной области составить линейную программу, котора€ печатает true, если точка с координатами (х, у) принадлежит закрашенной области,
и false Ч в противном случае */

public class Task1_6 {
	public static void main(String[] args) {
		double x = enterFromConsole("Input сoordinate x");
		double y = enterFromConsole("Input сoordinate y");
		boolean z = (x >= -2 && x <= 2 && y >= 0 && y <= 4) || (x >= -4 && x <= 4 && y <= 0 && y >= -3);
		System.out.println("Coordinate " + z);

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