package com.epam.upskil.main.logic;

import com.epam.upskil.main.content.Available;
import com.epam.upskil.main.content.Product;
import com.epam.upskil.main.content.Bouquet;
import com.epam.upskil.main.content.Flower;
import com.epam.upskil.main.content.FlowerPackaging;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateBouquet extends Available {
    private Bouquet bouquet;
    private ArrayList<Product> flowers;
    private FlowerPackaging flowerPackaging = null;

    public CreateBouquet() {

        flowers = new ArrayList<>();

        bouquet = new Bouquet(flowers, flowerPackaging);

        while (true) {
            System.out.println("1 - Добавить цветы в букет; 2 - Выбор упаковки; 3 - Просмотр; 4 - Завершить.");
            boolean stop = false;
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    Flower flower = addFlower();
                    while (flower == null) {
                        flower = addFlower();
                    }
                    break;

                case 2:
                    flowerPackaging = typePackaging();
                    while (flowerPackaging == null) {
                        flowerPackaging = typePackaging();
                    }
                    break;
                case 3:
                    System.out.println(bouquet);
                    break;
                case 4:
                    if (flowers.size() == 0) {
                        System.out.println("В букете отсутствуют цветы.");
                        Flower flower1 = addFlower();
                    }
                    else if (flowerPackaging == null) {
                        System.out.println("Букет без упаковки.");
                        flowerPackaging = typePackaging();
                    } else {
                        stop = true;
                    }
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
                    break;
            }
            bouquet = new Bouquet(flowers, flowerPackaging);
            if (stop) {
                break;
            }
        }
        System.out.println(bouquet);
    }


    public Bouquet getBouqet() {
        return bouquet;
    }


    private Flower addFlower() {
        System.out.println("В наличии есть следующие цветы:");
        for (Flower flower:getFlowers()) {
            System.out.println(flower +", цена - " +flower.getPrice() +"$");
        }
        System.out.print("Введите название цветов: ");
        String flowerName = new Scanner(System.in).nextLine();
        Flower flower = compareFlower(flowerName);
        if (flower == null) {
            return null;
        }
        int number = addNumberFlower();
        while (number <= 0) {
            number = 0;
            number = addNumberFlower();
        }
        for (int i = 0; i < number; i++) {
            flowers.add(flower);
        }
        return flower;
    }


    private int addNumberFlower() {
        System.out.print("Введите количество цветов: ");
        int number = new Scanner(System.in).nextInt();
        if (number <= 0) {
            System.out.println("Неверный выбор. Попробуйте еще раз.");
            number = 0;
        }
        return number;
    }


    private FlowerPackaging typePackaging() {
        System.out.println("Имеются следующие виды упаковок:");
        for (FlowerPackaging flowerPackaging:getFlowerPackagings()) {
            System.out.println(flowerPackaging + ", цена - "+flowerPackaging.getPrice() +"$");
        }
        System.out.print("Введите вид упаковки: ");
        String nameFlowerPackaging = new Scanner(System.in).nextLine();
        return compareFlowerPacking(nameFlowerPackaging);
    }
}
