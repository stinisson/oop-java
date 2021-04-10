package oop.exercises.napoleonsTomb;

import java.awt.*;

public class AnimationCard {
    int vx;
    int vy;
    Card card;

    // step function

    public AnimationCard(Card card) {
        this.card = card;
    }


    public void render(Graphics g, java.awt.image.ImageObserver observer) {
        card.render(g, observer);
    }
}
