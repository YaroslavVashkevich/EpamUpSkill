package com.epam.upskil.main.content;

import com.epam.upskil.main.logic.Cost;

import java.util.ArrayList;

public class Bouquet extends Cost implements FinishedProduct {
    private ArrayList<Product> flowers;
    private FlowerPackaging flowerPackaging;

    public Bouquet(ArrayList<Product> flowers, FlowerPackaging flowerPackaging) {
        super(flowers, flowerPackaging);
        this.flowers = flowers;
        this.flowerPackaging = flowerPackaging;
    }

    public String structure() {

        String structure = "";

        int rose = 0;
        int orchid = 0;
        int carnation = 0;
        int chamomile = 0;
        int tulip = 0;

        for (Product flower : flowers) {
            switch (flower.getType()) {
                case "Роза":
                    rose++;
                    break;
                case "Орхидея":
                    orchid++;
                    break;
                case "Гвоздика":
                    carnation++;
                    break;
                case "Ромашка":
                    chamomile++;
                    break;
                case "Тюльпан":
                    tulip++;
                    break;
            }
        }
        if (rose != 0) {
            structure += "Розы - " + rose + " ";
        }
        if (orchid != 0) {
            structure += "Орхидеи - " + orchid + " ";
        }
        if (carnation != 0) {
            structure += "Гвоздики - " + carnation + " ";
        }
        if (chamomile != 0) {
            structure += "Ромашки - " + chamomile + " ";
        }
        if (tulip != 0) {
            structure += "Тюльпаны - " + tulip + " ";
        }

        return structure;
    }

    public String toString() {
        return "Цветы: " + structure() + ", Упаковка - " + flowerPackaging + ", Цена - " + getPrice() + "$";
    }

    public ArrayList<Product> getFlowers() {
        return flowers;
    }

    public FlowerPackaging getFlowerPackaging() {
        return flowerPackaging;
    }

}
