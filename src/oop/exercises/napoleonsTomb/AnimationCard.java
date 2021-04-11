package oop.exercises.napoleonsTomb;
import java.util.Random;

import java.awt.*;

public class AnimationCard {
    private float x;
    private float y;
    private float vx;
    private float vy;
    private final Card card;
    private final int boardHeight;

    public AnimationCard(Card card, int boardHeight) {
        this.card = card;
        this.boardHeight = boardHeight;
        x = (float) card.getX();
        y = (float) card.getY();

        final Random rand = new Random();
        vx = (rand.nextFloat() - 0.5f)*10;
        vy = (rand.nextFloat() - 1.0f)*5;
    }

    public void step(boolean hasBottom) {
        x += vx;
        vy += 0.1;
        y += vy;

        if (hasBottom && y > boardHeight - Card.height) {
            float overshoot = y + Card.height - boardHeight;
            y = y - 2 * overshoot;
            vy *= -0.8;
        }
        card.setX((int) x);
        card.setY((int) y);
    }

    public void render(Graphics g, java.awt.image.ImageObserver observer) {
        card.render(g, observer);
    }
}
