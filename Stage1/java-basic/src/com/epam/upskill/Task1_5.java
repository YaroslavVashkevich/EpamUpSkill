package com.epam.upskill;

import java.util.Scanner;

/* 5. ���� ����������� ����� �, ������� ������������ ������������ ���������� ������� � ��������. ������� ������ �������� ������������ � �����,
������� � �������� � ��������� �����: ��� ����� SSc. */

public class Task1_5 {
	public static void main(String[] args) {
		int x = enterFromConsole("Input number sec");
		int h = x /3600;
		int m = (x % 3600) / 60;
		int s = (x % 3600) % 60;
		System.out.printf(h + "� " + m + "��� " + s + "c");

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