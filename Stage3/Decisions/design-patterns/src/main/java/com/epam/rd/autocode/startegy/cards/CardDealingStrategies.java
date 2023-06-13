package com.epam.rd.autocode.startegy.cards;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return new TexasStrategy();
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new ClassicStrategy();
    }

    public static CardDealingStrategy bridgeCardDealingStrategy() {
        return new BridgeStrategy();
    }

    public static CardDealingStrategy foolCardDealingStrategy() {
        return new FoolStrategy();
    }

}
