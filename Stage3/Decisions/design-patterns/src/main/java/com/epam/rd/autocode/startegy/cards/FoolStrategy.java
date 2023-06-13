package com.epam.rd.autocode.startegy.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoolStrategy implements CardDealingStrategy {
    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> cards = new HashMap();
        List[] player = new List[players];
        for (int i = 0; i < players; i++) {
            player[i] = new ArrayList<Card>();
        }
        List<Card> trumpCard = new ArrayList();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < player.length; j++) {
                player[j].add(deck.dealCard());
            }
        }
        trumpCard.add(deck.dealCard());
        for (int i = 1; i <= players; i++) {
            cards.put("Player " + i, player[i - 1]);
        }
        cards.put("Remaining", deck.restCards());
        cards.put("Trump card", trumpCard);
        return cards;
    }
}
