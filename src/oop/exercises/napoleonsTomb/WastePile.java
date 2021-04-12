package oop.exercises.napoleonsTomb;

import java.util.ArrayList;

public class WastePile extends Pile {

    protected WastePile(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public boolean put(Card card) {
        return false;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
