package oop.exercises.napoleonsTomb;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GameBoard extends JPanel {

    int yUpperRow = 50;
    int yLowerRow = 200;
    ArrayList<CardOutline> outlines;
    private static int cardWidth, space, startPos;
    Stock stock;
    WastePile wastePile;
    //Foundation[4]
    boolean resourcesLoaded = false;

    public GameBoard() {
        setBackground(Color.GREEN);
        MouseListener ml = new MouseListener(this);
        addMouseListener(ml);
        addMouseMotionListener(ml);

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

    public void paintComponent(Graphics g) {
        if (!resourcesLoaded) {
            return;
        }
        super.paintComponent(g);

        stock.render(g, this);
        wastePile.render(g, this);


//        for (Card card : wastePile.getWastePileCards()) {
//            card.render(g, this);
//        }

    }

    public void stockAction(int mx, int my) {
        if (stock.isEmpty()) {
            return;
        }

        if (stock.getTopCard().contains(mx, my)) {
            Card wasteCard = stock.getTopCard();
            wastePile.addCard(wasteCard);
            stock.removeTopCard();
            repaint();
        }
    }

    public void setUpBoard() {
        int pWidth = getWidth();
        cardWidth = 71;
        space = 30;
        startPos = (pWidth - 7 * cardWidth - 6 * space)/2;

        stock = new Stock(startPos + 5*space + 5*cardWidth, yUpperRow);
        wastePile = new WastePile(startPos + 6*space + 6*cardWidth, yUpperRow);
        //foundation[0] = new Foundation([x, y])
        //foundation[1] = new Foundation([x, y])
    }


    public void dealCards(boolean fixedOrder) {
        stock.dealCards(fixedOrder);
        wastePile.clearCards();
        //stock = new Stock(startPos + 5*space + 5*cardWidth, yUpperRow, fixedOrder);
        //wastePile = new WastePile(startPos + 6*space + 6*cardWidth, yUpperRow);
        resourcesLoaded = true;
        repaint();
    }

    public Card containsCard(int mx, int my) {
        return null;
    }

    public void moveCard(Card card, int x, int y) {

    }

/*
    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        System.out.println("Click at " + mx + " " + my);
        stockAction(mx, my);

    }*/
/*
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }*/

}
