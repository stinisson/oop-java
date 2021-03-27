package oop.exercises.klondike;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GameBoard extends JPanel {

    ArrayList<CardOutline> outlines;
    private static int cardWidth, space, startPos;
    Card card;

    public GameBoard() {
        setBackground(Color.GREEN);
    }

    public void addCardOutlines() {

        int pWidth = getWidth();
        cardWidth = 71;
        space = 30;
        startPos = (pWidth - 7 * cardWidth - 6 * space)/2;

        outlines = new ArrayList<>(0);
        outlines.add(new CardOutline(startPos, 50 ));
        outlines.add(new CardOutline(startPos + space + cardWidth, 50));
        outlines.add(new CardOutline(startPos + 2*space + 2*cardWidth, 50));
        outlines.add(new CardOutline(startPos + 3*space + 3*cardWidth, 50));
        outlines.add(new CardOutline(startPos + 5*space + 5*cardWidth, 50));
        outlines.add(new CardOutline(startPos + 6*space + 6*cardWidth, 50));

        outlines.add(new CardOutline(startPos, 200 ));
        outlines.add(new CardOutline(startPos + space + cardWidth, 200));
        outlines.add(new CardOutline(startPos + 2*space + 2*cardWidth, 200));
        outlines.add(new CardOutline(startPos + 3*space + 3*cardWidth, 200));
        outlines.add(new CardOutline(startPos + 4*space + 4*cardWidth, 200));
        outlines.add(new CardOutline(startPos + 5*space + 5*cardWidth, 200));
        outlines.add(new CardOutline(startPos + 6*space + 6*cardWidth, 200));

    }

    public void addCard() {
        card = new Card(startPos + 6*space + 6*cardWidth, 50);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CardOutline outline : outlines) {
            outline.render(g);
        }
        card.render(g);


    }

}
