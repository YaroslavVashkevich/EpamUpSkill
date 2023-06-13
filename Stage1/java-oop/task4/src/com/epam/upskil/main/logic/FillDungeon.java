package com.epam.upskil.main.logic;

import com.epam.upskil.main.content.Dungeon;
import com.epam.upskil.main.content.Treasure;
import com.epam.upskil.main.content.Coin;
import com.epam.upskil.main.content.Metal;
import com.epam.upskil.main.content.Copper;
import com.epam.upskil.main.content.Gold;
import com.epam.upskil.main.content.Silver;

import java.util.Random;


public class FillDungeon {
    private Metal[] metal = {new Gold(), new Silver(), new Copper()};

    public FillDungeon(Dungeon dungeon) {

        Random random = new Random();
        for (int i = 0; i < 100; i++) {

            dungeon.addTreasure(new Treasure(new Coin(), metal[random.nextInt(metal.length)], (int) (100 + Math.random() * 1000)));

        }

    }
}
