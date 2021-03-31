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
                cards.add(card);
            }
        }
        if (fixedOrder) {
            Collections.shuffle(cards, new Random(3));
        } else {
            Collections.shuffle(cards);
        }
    }

    public ArrayList<Card> getStockCards() {
        return cards;
    }

    public Card getTopCard() {
        return cards.get(cards.size() - 1);
    }

    public void removeTopCard() {
        cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

}
