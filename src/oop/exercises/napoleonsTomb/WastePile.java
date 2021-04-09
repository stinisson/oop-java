package oop.exercises.napoleonsTomb;

import java.util.ArrayList;

public class WastePile extends Pile {

    protected WastePile(int x, int y) {
        super(x, y);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        card.x = x;
        card.y = y;
        card.isUp = true;
        cards.add(card);
    }


}
