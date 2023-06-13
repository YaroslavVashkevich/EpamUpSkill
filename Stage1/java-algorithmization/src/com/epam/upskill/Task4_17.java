package com.epam.upskill;

import java.util.Scanner;

/*17. �� ��������� ����� ����� ����� ��� ����. �� ���������� ����� ����� ����� ��� ���� � �.�. 
      ������� ����� �������� ���� ����������, ����� ��������� ����? ��� ������� ������ ������������ ������������.*/

public class Task4_17 {
	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		subtraction(n);
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

	public static void subtraction(int n) {
		int count = 0;
		while (n > 0) {
			n = n - sum(n);
			count++;
		}
		System.out.println(count);
	}

	public static int sum(int n) {
		int sum = 0;
		while (n > 0) {
			sum = sum + (n % 10);
			n = n / 10;
		}
		return sum;
	}
}
