package com.epam.upskill;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        СoffeeMachine coffeeMachine = new СoffeeMachine();
        Drink[] allDrink = coffeeMachine.addDrink();
        for (Drink drink: allDrink) {
            System.out.println("№" + drink.getId() + " Price:" + drink.getPrice() + "$" + " " + drink.getName());
        }
        System.out.println("Insert a coin:");
        int coin = new Scanner(System.in).nextInt();
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        coinAcceptor.makeDrink(allDrink, coin);

    }
}