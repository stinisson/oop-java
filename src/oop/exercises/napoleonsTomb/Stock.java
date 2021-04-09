package oop.exercises.napoleonsTomb;

import java.util.Collections;
import java.util.Random;

public class Stock extends Pile {

    private static final int nColors = 4;
    private static final int nValues = 13;

    public Stock(int x, int y, String name) {
        super(x, y, name);
    }

    public void dealCards(boolean fixedOrder) {

        clearCards();

        for (int color = 0; color < nColors; color++) {
            for (int value = 0; value < nValues; value++) {
                Card card = new Card(x, y, color, value, "stock");
                cards.add(card);
            }
        }
        if (fixedOrder) {
            Collections.shuffle(cards, new Random(3));
        } else {
            Collections.shuffle(cards);
        }
    }

}
