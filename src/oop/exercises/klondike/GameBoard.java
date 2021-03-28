package oop.exercises.klondike;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GameBoard extends JPanel {

    int yUpperRow = 50;
    int yLowerRow = 200;

    ArrayList<CardOutline> outlines;
    private static int cardWidth, space, startPos;
    Stock stock;
    boolean resourcesLoaded = false;

    public GameBoard() {
        setBackground(Color.GREEN);
    }

    public void addCardOutlines() {

        int pWidth = getWidth();
        cardWidth = 71;
        space = 30;
        startPos = (pWidth - 7 * cardWidth - 6 * space)/2;

        outlines = new ArrayList<>(0);
        outlines.add(new CardOutline(startPos, yUpperRow ));
        outlines.add(new CardOutline(startPos + space + cardWidth, yUpperRow));
        outlines.add(new CardOutline(startPos + 2*space + 2*cardWidth, yUpperRow));
        outlines.add(new CardOutline(startPos + 3*space + 3*cardWidth, yUpperRow));
        outlines.add(new CardOutline(startPos + 5*space + 5*cardWidth, yUpperRow));
        outlines.add(new CardOutline(startPos + 6*space + 6*cardWidth, yUpperRow));

        outlines.add(new CardOutline(startPos, yLowerRow ));
        outlines.add(new CardOutline(startPos + space + cardWidth, yLowerRow));
        outlines.add(new CardOutline(startPos + 2*space + 2*cardWidth, yLowerRow));
        outlines.add(new CardOutline(startPos + 3*space + 3*cardWidth, yLowerRow));
        outlines.add(new CardOutline(startPos + 4*space + 4*cardWidth, yLowerRow));
        outlines.add(new CardOutline(startPos + 5*space + 5*cardWidth, yLowerRow));
        outlines.add(new CardOutline(startPos + 6*space + 6*cardWidth, yLowerRow));

    }

    public void addStock() {
        stock = new Stock(startPos + 5*space + 5*cardWidth, yUpperRow);
        resourcesLoaded = true;
    }

    public void paintComponent(Graphics g) {
        if (!resourcesLoaded) {
            return;
        }

        super.paintComponent(g);
        for (CardOutline outline : outlines) {
            outline.render(g);
        }

        for (Card card : stock.getStockCards()) {
            card.render(g, this);
        }


    }

}
