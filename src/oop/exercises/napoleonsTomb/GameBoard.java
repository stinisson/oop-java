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

    WastePile wastePile00;
    WastePile wastePile01;
    WastePile wastePile02;
    WastePile wastePile03;
    WastePile wastePile04;
    WastePile wastePile05;
    WastePile wastePile06;

    WastePile wastePile10;
    WastePile wastePile11;
    WastePile wastePile12;
    WastePile wastePile13;
    WastePile wastePile14;
    WastePile wastePile15;
    WastePile wastePile16;

    WastePile wastePile20;
    WastePile wastePile21;
    WastePile wastePile22;
    WastePile wastePile23;
    WastePile wastePile24;
    WastePile wastePile25;
    WastePile wastePile26;


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

/*
        stock.render(g, this);
        wastePile.render(g, this);
*/



        //wastePile00.render(g, this);
        wastePile01.render(g, this);
        wastePile02.render(g, this);
        wastePile03.render(g, this);
        //wastePile04.render(g, this);
        wastePile05.render(g, this);
        wastePile06.render(g, this);

        //wastePile10.render(g, this);
        wastePile11.render(g, this);
        wastePile12.render(g, this);
        wastePile13.render(g, this);
        //wastePile14.render(g, this);
        //wastePile15.render(g, this);
        //wastePile16.render(g, this);

        //wastePile20.render(g, this);
        wastePile21.render(g, this);
        wastePile22.render(g, this);
        wastePile23.render(g, this);
        //wastePile24.render(g, this);
        //wastePile25.render(g, this);
        wastePile26.render(g, this);



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
        int pHeight = getHeight();
        System.out.println(pWidth);
        System.out.println(pHeight);


        cardWidth = 71;

        space = 30;
        startPos = (pWidth - 7 * cardWidth - 6 * space)/2;

        stock = new Stock(startPos + 5*space + 5*cardWidth, yUpperRow);
        wastePile = new WastePile(startPos + 6*space + 6*cardWidth, yUpperRow);

        int cardHeight = 96;
        int numCols = 7;
        int margin = (pWidth - numCols*cardWidth)/8;
        int offset = 20;

        wastePile00 = new WastePile(margin, margin + offset);
        wastePile01= new WastePile(cardWidth + 2 * margin - offset, margin);
        wastePile02= new WastePile(2 * cardWidth + 3 * margin, margin + offset);
        wastePile03= new WastePile(3 * cardWidth + 4 * margin + offset, margin);
        wastePile04= new WastePile(4 * cardWidth + 5 * margin, margin + offset);
        wastePile05= new WastePile(5 * cardWidth + 6 * margin, margin + offset);
        wastePile06= new WastePile(6 * cardWidth + 7 * margin, margin + offset);

        wastePile10 = new WastePile(margin, cardHeight + 2 * margin + offset);
        wastePile11= new WastePile(cardWidth + 2 * margin, cardHeight+ 2 * margin + offset);
        wastePile12= new WastePile(2 * cardWidth + 3 * margin, cardHeight+ 2 * margin + offset);
        wastePile13= new WastePile(3 * cardWidth + 4 * margin, cardHeight+ 2 * margin + offset);
        wastePile14= new WastePile(4 * cardWidth + 5 * margin, cardHeight+ 2 * margin + offset);
        wastePile15= new WastePile(5 * cardWidth + 6 * margin, cardHeight+ 2 * margin + offset);
        wastePile16= new WastePile(6 * cardWidth + 7 * margin, cardHeight+ 2 * margin + offset);

        wastePile20 = new WastePile(margin, 2 * cardHeight + 3 * margin + offset);
        wastePile21= new WastePile(cardWidth + 2 * margin - offset, 2 * cardHeight + 3 * margin + 2 * offset);
        wastePile22= new WastePile(2 * cardWidth + 3 * margin, 2 * cardHeight + 3 * margin + offset);
        wastePile23= new WastePile(3 * cardWidth + 4 * margin + offset, 2 * cardHeight + 3 * margin + 2 * offset);
        wastePile24= new WastePile(4 * cardWidth + 5 * margin, 2 * cardHeight + 3 * margin + offset);
        wastePile25= new WastePile(5 * cardWidth + 6 * margin, 2 * cardHeight + 3 * margin + offset);
        wastePile26= new WastePile(6 * cardWidth + 7 * margin, 2 * cardHeight + 3 * margin + offset);

/*

        wastePile00 = new WastePile(0*cardWidth +1*margin, margin + offset);
        wastePile01= new WastePile(1*cardWidth + 2*margin - offset, margin - offset+ offset);
        wastePile02= new WastePile(2*cardWidth + 3*margin, margin + offset);
        wastePile03= new WastePile(3*cardWidth + 4*margin+offset, margin- offset + offset);
        wastePile04= new WastePile(4*cardWidth + 5*margin, margin + offset);
        wastePile05= new WastePile(5*cardWidth + 6*margin, margin + offset);
        wastePile06= new WastePile(6*cardWidth + 7*margin, margin + offset);

        wastePile10 = new WastePile(0*cardWidth +1*margin, 1*cardHeight+ 2*margin+offset);
        wastePile11= new WastePile(1*cardWidth + 2*margin, 1*cardHeight+ 2*margin+offset);
        wastePile12= new WastePile(2*cardWidth + 3*margin, 1*cardHeight+ 2*margin+offset);
        wastePile13= new WastePile(3*cardWidth + 4*margin, 1*cardHeight+ 2*margin+offset);
        wastePile14= new WastePile(4*cardWidth + 5*margin, 1*cardHeight+ 2*margin+offset);
        wastePile15= new WastePile(5*cardWidth + 6*margin, 1*cardHeight+ 2*margin+offset);
        wastePile16= new WastePile(6*cardWidth + 7*margin, 1*cardHeight+ 2*margin+offset);

        wastePile20 = new WastePile(0*cardWidth +1*margin, 2*cardHeight+ 3*margin+offset);
        wastePile21= new WastePile(1*cardWidth + 2*margin - offset, 2*cardHeight+ 3*margin + offset+offset);
        wastePile22= new WastePile(2*cardWidth + 3*margin, 2*cardHeight+ 3*margin+offset);
        wastePile23= new WastePile(3*cardWidth + 4*margin + offset, 2*cardHeight+ 3*margin + offset+offset);
        wastePile24= new WastePile(4*cardWidth + 5*margin, 2*cardHeight+ 3*margin+offset);
        wastePile25= new WastePile(5*cardWidth + 6*margin, 2*cardHeight+ 3*margin+offset);
        wastePile26= new WastePile(6*cardWidth + 7*margin, 2*cardHeight+ 3*margin+offset);
*/


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
