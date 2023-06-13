package com.epam.upskill;

public class Сhocolate extends Drink {
    private double chocolate;
    private double milk;

    public Сhocolate(int id, String name, int price, double water, double chocolate, double milk) {
        super(id, name, price, water);
        this.chocolate = chocolate;
        this.milk = milk;
    }

    public void makeВrink() {
        System.out.println("Сhocolate ready.");
    }
}
