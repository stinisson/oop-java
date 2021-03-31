package oop.exercises.napoleonsTomb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Stock extends Pile {

    private static final int nColors = 4;
    private static final int nValues = 13;

    public Stock(int x, int y) {
        super(x, y);
    }

    public void dealCards(boolean fixedOrder) {
        for (int color = 0; color < nColors; color++) {
            for (int value = 0; value < nValues; value++) {
                Card card = new Card(x, y, color, value);
                stockCards.add(card);
            }
        }
        if (fixedOrder) {
            Collections.shuffle(stockCards, new Random(3));
        } else {
            Collections.shuffle(stockCards);
        }
    }

    public ArrayList<Card> getStockCards() {
        return stockCards;
    }

    public Card getTopCard() {
        return stockCards.get(stockCards.size() - 1);
    }

    public void removeTopCard() {
        stockCards.remove(stockCards.size() - 1);
    }

    public boolean isEmpty() {
        return stockCards.isEmpty();
    }

}
