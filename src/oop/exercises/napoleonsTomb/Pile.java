package oop.exercises.napoleonsTomb;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

abstract class Pile {

    protected final ArrayList<Card> cards;
    protected int x, y;
    private final CardOutline cardOutline;
    protected String name;

    protected Pile(int x, int y, String name) {
        this.x = x;
        this.y = y;
        cards = new ArrayList<>();
        cardOutline = new CardOutline(x, y);
        this.name = name;
    }

    public void clearCards() {
        cards.clear();
    }

    public String getName() {
        return name;
    }

    protected void render(Graphics g, java.awt.image.ImageObserver observer) {
        cardOutline.render(g);
        if (!isEmpty()) {
            getTopCard().render(g, observer);
        }
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

    public void addCard(Card card) {
        card.x = x;
        card.y = y;
        card.isUp = true;
        cards.add(card);
    }

    public boolean put(Card card) {
        return false;
    }

    protected boolean inRange(Card card) {
        int range = card.cardWidth / 2;
        int dx = abs(card.getPosition()[0] - x);
        int dy = abs(card.getPosition()[1] - y);
        return dx < range && dy < range;
    }

}
