package com.epam.upskill;

import java.util.Scanner;

/* 4. ���� �������������� ����� R ���� nnn.ddd (��� �������� ������� � ������� � ����� ������).
�������� ������� ������� � ����� ����� ����� � ������� ���������� �������� �����. */

public class Task1_4 {
	public static void main(String[] args) {
		double x = enterFromConsole("Input number x");
		double y = (int) x;
		double result = y / 1000 + (x % 1) * 1000;
		System.out.printf("%.3f", result);

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