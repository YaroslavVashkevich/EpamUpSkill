package com.epam.upskil.main.content;

public class GiftPackaging implements Packaging {
    private String type;
    private double price;

    public GiftPackaging(String type, double price) {

        this.type = type;
        this.price = price;

    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return type;
    }
}
