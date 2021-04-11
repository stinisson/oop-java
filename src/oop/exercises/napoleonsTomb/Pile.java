package oop.exercises.napoleonsTomb;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

abstract class Pile {

    protected int x, y;
    protected final String name;
    protected final ArrayList<Card> cards;
    private final CardOutline cardOutline;

    protected Pile(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        cards = new ArrayList<>();
        cardOutline = new CardOutline(x, y, name);
    }

    public void clearCards() {
        cards.clear();
    }

    public String getName() {
        return name;
    }

    protected void render(Graphics g, java.awt.image.ImageObserver observer) {
        cardOutline.render(g, observer);
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

    public void addCard(Card card, boolean isUp) {
        card.setX(x);
        card.setY(y);
        card.setIsUp(isUp);
        cards.add(card);
    }

    public boolean put(Card card) {
        return false;
    }

    protected boolean inRange(Card card) {
        int range = Card.width / 2;
        int dx = abs(card.getPosition()[0] - x);
        int dy = abs(card.getPosition()[1] - y);
        return dx < range && dy < range;
    }
}
