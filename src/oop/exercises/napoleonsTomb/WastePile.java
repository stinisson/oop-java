package oop.exercises.napoleonsTomb;

import java.util.ArrayList;

public class WastePile extends Pile {

    protected WastePile(int x, int y, String name) {
        super(x, y, name);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
