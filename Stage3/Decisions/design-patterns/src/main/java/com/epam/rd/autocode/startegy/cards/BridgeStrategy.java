package com.epam.rd.autocode.startegy.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeStrategy implements CardDealingStrategy {
    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> cards = new HashMap();
        List[] player = new List[players];
        for (int i = 0; i < players; i++) {
            player[i] = new ArrayList<Card>();
        }
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < player.length; j++) {
                player[j].add(deck.dealCard());
            }
        }
        for (int i = 1; i <= players; i++) {
            cards.put("Player " + i, player[i - 1]);
        }
        return cards;
    }
}
