package com.epam.upskill;

public class СoffeeMachine {
    private Drink[] listDrinks = new Drink[6];
    public Drink[] addDrink() {
        listDrinks[0] = new Coffee(1, "Espresso", 1, 100, 20, 0);
        listDrinks[1] = new Coffee(2, "Americano", 1, 150, 40, 0);
        listDrinks[2] = new Coffee(3, "Cappuccino", 2, 150, 30, 50);
        listDrinks[3] = new Coffee(4, "Latte",2 ,100, 50, 100);
        listDrinks[4] = new Сhocolate(5, "Сhocolate", 2, 100, 50, 50);
        listDrinks[5] = new Tea(6, "Tea", 1, 100, 15);
        return listDrinks;
    }

}
