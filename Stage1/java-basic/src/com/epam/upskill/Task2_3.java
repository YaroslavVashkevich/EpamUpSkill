package com.epam.upskill;

import java.util.Scanner;

// 3. ���� ��� ����� �(�1,�1), �(�2,�2) � �(�3,�3). ����������, ����� �� ��� ����������� �� ����� ������.

public class Task2_3 {
	public static void main(String[] args) {
		double x1 = enterFromConsole("Input �oordinate x1");
		double y1 = enterFromConsole("Input �oordinate y1");
		double x2 = enterFromConsole("Input �oordinate x2");
		double y2 = enterFromConsole("Input �oordinate y2");
		double x3 = enterFromConsole("Input �oordinate x3");
		double y3 = enterFromConsole("Input �oordinate y3");
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