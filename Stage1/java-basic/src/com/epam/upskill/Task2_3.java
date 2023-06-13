package com.epam.upskill;

import java.util.Scanner;

// 3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.

public class Task2_3 {
	public static void main(String[] args) {
		double x1 = enterFromConsole("Input сoordinate x1");
		double y1 = enterFromConsole("Input сoordinate y1");
		double x2 = enterFromConsole("Input сoordinate x2");
		double y2 = enterFromConsole("Input сoordinate y2");
		double x3 = enterFromConsole("Input сoordinate x3");
		double y3 = enterFromConsole("Input сoordinate y3");
		if ((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1) == 0) {
			System.out.println("The points lie on a straight line.");
		} else {
			System.out.println("The points do not lie on the same straight line.");
		}

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