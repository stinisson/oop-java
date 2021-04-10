package oop.exercises.napoleonsTomb;
import java.util.Random;

import java.awt.*;

public class AnimationCard {
    float x;
    float y;
    float vx;
    float vy;
    Card card;

    int boardHeight = 500;


    public AnimationCard(Card card) {
        this.card = card;
        vx = 0;
        vy = 0;
        x = card.x;
        y = card.y;

        final Random rand = new Random();
        vx = (rand.nextFloat() - 0.5f)*10;
        vy = (rand.nextFloat() - 1.0f)*5;
    }

    public void step(boolean hasBottom) {
        x += vx;
        vy += 0.1;
        y += vy;

        if (hasBottom && y > boardHeight - card.height) {
            float overshoot = y + card.height- boardHeight;
            y = y - 2 * overshoot;
            vy *= -0.8;
        }

        card.x = (int) x;
        card.y = (int) y;
    }


    public void render(Graphics g, java.awt.image.ImageObserver observer) {
        card.render(g, observer);
    }
}
