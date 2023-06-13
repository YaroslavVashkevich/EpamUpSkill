package com.epam.upskill;

public class Coffee extends Drink {
    private double coffee;
    private double milk;

    public Coffee(int id, String name, int price, double water, double coffee, double milk) {
        super(id, name, price, water);
        this.coffee = coffee;
        this.milk = milk;
    }

    public void makeВrink() {
        System.out.println("Coffee ready.");
    }
}
