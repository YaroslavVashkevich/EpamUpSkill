package com.epam.upskill;

import java.util.Scanner;

// 1. ���� ��� ���� ������������ (� ��������). ����������, ���������� �� ����� �����������, � ���� ��, �� ����� �� �� �������������.

public class Task2_1 {
	public static void main(String[] args) {
		double a = enterFromConsole("Input �orner 1");
		double b = enterFromConsole("Input �orner 2");
		
		if (180 - (a + b) > 0 && a != 0 && b != 0) {
			System.out.println("The triangle exist.");
			if (180 - (a + b) == 90 || a == 90 || b == 90) {
				System.out.println("Right triangle.");
			}
		} else {
			System.out.println("The triangle doesn't exist.");
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
