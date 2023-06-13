package com.epam.upskill;

public class Tea extends Drink {
    private double tea;

    public Tea(int id, String name, int price, double water, double tea) {
        super(id, name, price, water);
        this.tea = tea;
    }

    public void makeВrink() {
        System.out.println("Tea ready.");
    }
}
