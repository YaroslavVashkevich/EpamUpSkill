package com.epam.upskil.main;

import com.epam.upskil.main.content.Dungeon;
import com.epam.upskil.main.logic.FillDungeon;

import java.util.Scanner;

//4.Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Приложение должно быть объектно-, а не процедурно-ориентированным.
//• Каждый класс должен иметь отражающее смысл название и информативный состав.
//• Наследование должно применяться только тогда, когда это имеет смысл.
//• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//• Классы должны быть грамотно разложены по пакетам.
//• Консольное меню должно быть минимальным.
//• Для хранения данных можно использовать файлы.
//Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
// Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ
// на заданную сумму.

public class Main {
    public static void main(String[] args) {

        Dungeon dungeon = new Dungeon();
        FillDungeon fillDungeon = new FillDungeon(dungeon);

        while (true) {
            System.out.print("1-Просмотр сокровищ; 2-Самое дорогое сокровище; 3-Выбор сокровища; 4-закончить\n");
            System.out.print("Введите неоходимый номер: ");
            boolean run = false;
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    dungeon.print();
                    break;
                case 2:
                    dungeon.maxPrice(dungeon);
                    break;
                case 3:
                    dungeon.specified(dungeon);
                    break;
                case 4:
                    run = true;
                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
            }
            if (run) {
                break;
            }
        }
    }
}
