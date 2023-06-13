package com.epam.upskil.main.content;

public class Sweetness implements Product {
    private String type;
    private double price;

    public Sweetness(String sort, double price) {

        this.type = sort;
        this.price = price;

    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    public String toString() {
        return type;
    }
}
