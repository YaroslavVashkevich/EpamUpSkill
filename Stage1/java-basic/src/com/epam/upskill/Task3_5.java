package com.epam.upskill;

// 5. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.

public class Task3_5 {
	public static void main(String[] args) {
		int x = 33;
		int y = 125;
		for (int i = x; i <= y; i++) {
			System.out.println("Number " + i + " = Symbol " + (char) i);
		}

	}

}