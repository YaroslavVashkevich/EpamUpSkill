package com.epam.upskill;

//7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления площади,
// периметра и точки пересечения медиан.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Triangle triangle = new Triangle();
        int x1 = enterFromConsole("Input Coordinates of the point x1 ");
        int y1 = enterFromConsole("Input Coordinates of the point y1 ");
        int x2 = enterFromConsole("Input Coordinates of the point x2 ");
        int y2 = enterFromConsole("Input Coordinates of the point y2 ");
        int x3 = enterFromConsole("Input Coordinates of the point x3 ");
        int y3 = enterFromConsole("Input Coordinates of the point y3 ");
        triangle.setX1(x1);
        triangle.setY1(y1);
        triangle.setX2(x2);
        triangle.setY2(y2);
        triangle.setX3(x3);
        triangle.setY3(y3);

        calculation(triangle);
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

    public static void calculation(Triangle triangle) {
        if (triangle.getCheck() == true) {
            System.out.println("The triangle doesn't exist!");
        } else {
            System.out.println("Area = " + triangle.getS() + " Perimeter = " + triangle.getP() + " Median X,Y " + "("+ triangle.getMx() + "," + triangle.getMy() + ")");
        }
    }


}
