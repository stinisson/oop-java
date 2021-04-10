package oop.exercises.napoleonsTomb;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Animation {

    protected final ArrayList<AnimationCard> animationCards;
    private static final int timeStep = 33;
    private static final int animationLength = 10000;
    int animationTime = 0;

    public Animation() {
        animationCards = new ArrayList<>();
    }

    public boolean step() {
        if (animationTime > animationLength) {
            clearCards();
            return false;
        }

        for (AnimationCard animationCard: animationCards) {
            boolean hasBottom = true;
            if (animationTime > 5000) {
                hasBottom = false;
            }
            animationCard.step(hasBottom);
        }

        try {
            Thread.sleep(timeStep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        animationTime += timeStep;
        return true;
    }


    private void clearCards() {
        animationCards.clear();
    }

    public void addPiles(HashMap<String, Pile> piles) {
        for (Pile pile : piles.values()) {
            for (Card card: pile.cards) {
                AnimationCard animationCard = new AnimationCard(card);
                animationCards.add(animationCard);
            }
        }
    }

    public void render(Graphics g, java.awt.image.ImageObserver observer) {
        for (AnimationCard animationCard : animationCards) {
            animationCard.render(g, observer);
        }
    }
}
