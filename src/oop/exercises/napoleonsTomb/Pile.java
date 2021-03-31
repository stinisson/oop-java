package oop.exercises.napoleonsTomb;

import java.awt.*;
import java.util.ArrayList;

abstract class Pile {

    protected final ArrayList<Card> cards;
    protected int x, y;
    private final CardOutline cardOutline;

    protected Pile(int x, int y) {
        this.x = x;
        this.y = y;
        cards = new ArrayList<>();
        cardOutline = new CardOutline(x, y);
    }

    public void clearCards() {
        cards.clear();
    }

    protected void render(Graphics g, java.awt.image.ImageObserver observer) {

        cardOutline.render(g);

        for (Card card : cards) {
            card.render(g, observer);
        }
    }

}
