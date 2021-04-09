package oop.exercises.napoleonsTomb;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GameBoard extends JPanel {

    int yUpperRow = 50;
    int yLowerRow = 200;
    ArrayList<CardOutline> outlines;
    private static int cardWidth, space, startPos;
    boolean resourcesLoaded = false;

    Foundation7 foundationLT;
    Foundation7 foundationRT;
    Foundation7 foundationLB;
    Foundation7 foundationRB;

    Foundation6 foundationM;

    Tableau tableauT;
    Tableau tableauLM;
    Tableau tableauRM;
    Tableau tableauB;

    Stock stock;
    WastePile wastePile;
    Parking parking;
    //Foundation[4]


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

        foundationLT.render(g, this);
        foundationRT.render(g, this);
        foundationLB.render(g, this);
        foundationRB.render(g, this);

        foundationM.render(g, this);

        tableauT.render(g, this);
        tableauLM.render(g, this);
        tableauRM.render(g, this);
        tableauB.render(g, this);

        stock.render(g, this);
        wastePile.render(g, this);
        parking.render(g, this);

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



/*
        space = 30;
        startPos = (pWidth - 7 * cardWidth - 6 * space)/2;
        stock = new Stock(startPos + 5*space + 5*cardWidth, yUpperRow);
        wastePile = new WastePile(startPos + 6*space + 6*cardWidth, yUpperRow);*/


        cardWidth = 71;
        int cardHeight = 96;
        int numCols = 7;
        int margin = (pWidth - numCols*cardWidth)/8;
        int offset = 20;

        foundationLT = new Foundation7(cardWidth + 2 * margin - offset, margin);
        foundationRT = new Foundation7(3 * cardWidth + 4 * margin + offset, margin);
        foundationLB = new Foundation7(cardWidth + 2 * margin - offset, 2 * cardHeight + 3 * margin + 2 * offset);
        foundationRB = new Foundation7(3 * cardWidth + 4 * margin + offset, 2 * cardHeight + 3 * margin + 2 * offset);

        foundationM = new Foundation6(2 * cardWidth + 3 * margin, cardHeight+ 2 * margin + offset);

        tableauT = new Tableau(2 * cardWidth + 3 * margin, margin + offset);
        tableauLM = new Tableau(cardWidth + 2 * margin, cardHeight+ 2 * margin + offset);
        tableauRM = new Tableau(3 * cardWidth + 4 * margin, cardHeight+ 2 * margin + offset);
        tableauB = new Tableau(2 * cardWidth + 3 * margin, 2 * cardHeight + 3 * margin + offset);

        stock = new Stock(5 * cardWidth + 6 * margin, margin + offset);
        wastePile = new WastePile(6 * cardWidth + 7 * margin, margin + offset);
        parking = new Parking(6 * cardWidth + 7 * margin, 2 * cardHeight + 3 * margin + offset);


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
