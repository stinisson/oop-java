package oop.exercises.klondike;

import java.util.ArrayList;

public class Stock {

    int deck = 52;
    ArrayList<Card> stockCards;

    public Stock(int x, int y) {

        stockCards = new ArrayList<>(deck);
        for (int i = 0; i < deck; i ++) {
           Card card = new Card(x, y);
           stockCards.add(card);
        }
    }

    public ArrayList<Card> getStockCards() {
        return stockCards;
    }
}
