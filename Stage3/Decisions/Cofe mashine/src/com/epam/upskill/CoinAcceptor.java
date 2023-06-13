package com.epam.upskill;

import java.util.Scanner;

public class CoinAcceptor {
    private int coin;

    public void makeDrink(Drink[] allDrink, int coin) {
        for (Drink drink : allDrink) {
            if (drink.getPrice() <= coin)
                System.out.println("№" + drink.getId() + " Price:" + drink.getPrice() + "$" + " " + drink.getName());
        }
        System.out.println("Choose drink:");
        int drink = new Scanner(System.in).nextInt();
            switch (drink) {
                case 1:
                    Coffee espresso = new Coffee(1, "Espresso", 1, 100, 20, 0);
                    espresso.makeВrink();
                    break;
                case 2:
                    Coffee americano = new Coffee(2, "Americano", 1, 150, 40, 0);
                    americano.makeВrink();
                    break;
                case 3:
                    Coffee cappuccino = new Coffee(3, "Cappuccino", 2, 150, 30, 50);
                    cappuccino.makeВrink();
                    break;
                case 4:
                    Coffee latte = new Coffee(4, "Latte", 2, 100, 50, 100);
                    latte.makeВrink();
                    break;
                case 5:
                    Сhocolate chocolate = new Сhocolate(5, "Сhocolate", 2, 100, 50, 50);
                    chocolate.makeВrink();
                    break;
                case 6:
                    Tea tea = new Tea(6, "Tea", 1, 100, 15);
                    tea.makeВrink();
                    break;
        }
    }
}
