package com.epam.upskill;

abstract public class Drink {
    private int id;
    private String name;
    private int price;
    private double water;

    public Drink(int id, String name, int price, double water) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.water = water;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    abstract public void makeВrink();
}
