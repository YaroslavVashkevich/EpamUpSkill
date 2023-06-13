package com.epam.upskil.main.content;

import java.util.ArrayList;
import com.epam.upskil.main.logic.Choose;

public class Dungeon extends Choose {
    private ArrayList<Treasure> treasures = new ArrayList<>();

    public void print() {
        for (Treasure treasure : getTreasures()) {
            System.out.println(treasure);
        }
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }
}
