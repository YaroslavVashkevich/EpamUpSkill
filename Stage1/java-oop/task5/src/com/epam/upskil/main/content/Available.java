package com.epam.upskil.main.content;

import java.util.ArrayList;

public class Available {
    private ArrayList<Flower> flowers = new ArrayList<>();
    private ArrayList<FlowerPackaging> flowerPackagings = new ArrayList<>();

    private ArrayList<Sweetness> sweetness = new ArrayList<>();
    private ArrayList<GiftPackaging> giftPackagings = new ArrayList<>();

    public Available() {

        flowers.add(new Flower("Роза", 4));
        flowers.add(new Flower("Орхидея", 10));
        flowers.add(new Flower("Гвоздика", 3));
        flowers.add(new Flower("Ромашка", 2));
        flowers.add(new Flower("Тюльпан", 1));

        flowerPackagings.add(new FlowerPackaging("Бумага", 2));
        flowerPackagings.add(new FlowerPackaging("Пленка", 3));
        flowerPackagings.add(new FlowerPackaging("Сетка", 4));

        sweetness.add(new Sweetness("Шоколад", 6.5));
        sweetness.add(new Sweetness("Зефир", 5));
        sweetness.add(new Sweetness("Карамель", 4));
        sweetness.add(new Sweetness("Печенье", 3));
        sweetness.add(new Sweetness("Мармелад", 5));

        giftPackagings.add(new GiftPackaging("Пакет", 0.2));
        giftPackagings.add(new GiftPackaging("Блистер", 0.5));
        giftPackagings.add(new GiftPackaging("Коробка", 0.8));

    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addFlowerPackaging(FlowerPackaging flowerPackaging) {
        flowerPackagings.add(flowerPackaging);
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public ArrayList<FlowerPackaging> getFlowerPackagings() {
        return flowerPackagings;
    }

    public ArrayList<Sweetness> getSweetness() {
        return sweetness;
    }

    public ArrayList<GiftPackaging> getGiftPackagings() {
        return giftPackagings;
    }


    public Sweetness compareSweetness(String name, ArrayList<Sweetness> arrayList) {
        for (Sweetness sweetness : arrayList) {
            if (sweetness.getType().equals(name)) {
                return sweetness;
            }
        }
        System.out.println("Данные сладости отсутствуют.");
        return null;
    }

    public GiftPackaging compareGiftPacking(String name) {
        for (GiftPackaging packaging : giftPackagings) {
            if (packaging.getType().equals(name)) {
                return packaging;
            }
        }
        System.out.println("Данная упаковка отсутствует.");
        return null;
    }

    public Flower compareFlower(String name) {
        for (Flower flower : flowers) {
            if (flower.getType().equals(name)) {
                return flower;
            }
        }
        System.out.println("Данные цветы отсутствуют.");
        return null;
    }

    public FlowerPackaging compareFlowerPacking(String name) {
        for (FlowerPackaging flowerPackaging : flowerPackagings) {
            if (flowerPackaging.getType().equals(name)) {
                return flowerPackaging;
            }
        }
        System.out.println("Данная упаковка отсутствует.");
        return null;
    }
}
