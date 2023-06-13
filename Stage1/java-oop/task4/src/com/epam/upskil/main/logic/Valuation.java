package com.epam.upskil.main.logic;

import com.epam.upskil.main.content.Treasure;
import com.epam.upskil.main.content.Coin;
import com.epam.upskil.main.content.Metal;

public class Valuation {
    private double price;

    public Valuation(Treasure treasure) {
        price = treasure.getCoin().getWeight() * treasure.getNumber() * treasure.getMetal().getPrice();
    }

    public Valuation(Coin coin, Metal metal, int number) {
        price = coin.getWeight() * number * metal.getPrice();
    }

    public double getPrice() {
        return price;
    }
}
