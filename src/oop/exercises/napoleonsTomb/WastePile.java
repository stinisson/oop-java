package oop.exercises.napoleonsTomb;

import java.util.ArrayList;

public class WastePile {

    ArrayList<Card> wastePileCards;
    int x, y;

    public WastePile(int x, int y) {
        this.x = x;
        this.y = y;
        wastePileCards = new ArrayList<>(0);
    }

    public ArrayList<Card> getWastePileCards() {
        return wastePileCards;
    }

    public void addCard(Card card) {
        card.x = x;
        card.y = y;
        card.isUp = true;
        wastePileCards.add(card);
    }


}
