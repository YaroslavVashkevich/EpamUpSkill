package com.epam.upskil.main;

import com.epam.upskil.main.content.FinishedProduct;
import com.epam.upskil.main.logic.CreateBouquet;
import com.epam.upskil.main.logic.CreateGift;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private ArrayList<FinishedProduct> basket = new ArrayList<>();

    public Client() {

        while (true) {
            System.out.println("1-Создать букет; 2-Создать подарок; 3-Закончить.  ");
            System.out.print("Введите необходимый номер: ");
            boolean stop = false;
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    CreateBouquet createBouquet = new CreateBouquet();
                    basket.add(createBouquet.getBouqet());
                    break;
                case 2:
                    CreateGift createGift = new CreateGift();
                    basket.add(createGift.getGift());
                    break;
                case 3:
                    stop = true;
                    break;
                default:
                    System.out.println("Неверный номер. Попробуйте ещё раз.");
            }
            if (stop) {
                break;
            }
        }
        for (FinishedProduct product : basket) {
            System.out.println(product.toString());
        }
    }
}
