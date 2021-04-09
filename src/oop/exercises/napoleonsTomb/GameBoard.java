package oop.exercises.napoleonsTomb;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class GameBoard extends JPanel {

    boolean resourcesLoaded = false;
     HashMap<String, Pile> piles;

    public GameBoard() {
        setBackground(Color.GREEN);
        MouseListener ml = new MouseListener(this);
        addMouseListener(ml);
        addMouseMotionListener(ml);

    }

    public void paintComponent(Graphics g) {
        if (!resourcesLoaded) {
            return;
        }
        super.paintComponent(g);

        for (Pile pile : piles.values()) {
            pile.render(g, this);
        }

    }

    public void stockAction(int mx, int my) {
        if (piles.get("stock").isEmpty()) {
            return;
        }

        if (piles.get("stock").getTopCard().contains(mx, my)) {
            Card wasteCard = piles.get("stock").getTopCard();
            piles.get("wastePile").addCard(wasteCard);
            piles.get("stock").removeTopCard();
            repaint();
        }
    }
    
    public void setUpBoard() {
        int pWidth = getWidth();
        int cardWidth = 71;
        int cardHeight = 96;
        int numCols = 7;
        int offset = 20;
        int margin = (pWidth - numCols*cardWidth)/8;

        piles = new HashMap<>();
        piles.put("foundationLT", new Foundation7(cardWidth + 2 * margin - offset, margin));
        piles.put("foundationRT", new Foundation7(3 * cardWidth + 4 * margin + offset, margin));
        piles.put("foundationLB", new Foundation7(cardWidth + 2 * margin - offset, 2 * cardHeight + 3 * margin + 2 * offset));
        piles.put("foundationRB", new Foundation7(3 * cardWidth + 4 * margin + offset, 2 * cardHeight + 3 * margin + 2 * offset));
        piles.put("foundationM", new Foundation6(2 * cardWidth + 3 * margin, cardHeight+ 2 * margin + offset));
        piles.put("tableauT", new Tableau(2 * cardWidth + 3 * margin, margin + offset));
        piles.put("tableauLM", new Tableau(cardWidth + 2 * margin, cardHeight+ 2 * margin + offset));
        piles.put("tableauRM", new Tableau(3 * cardWidth + 4 * margin, cardHeight+ 2 * margin + offset));
        piles.put("tableauB", new Tableau(2 * cardWidth + 3 * margin, 2 * cardHeight + 3 * margin + offset));
        piles.put("stock", new Stock(5 * cardWidth + 6 * margin, margin + offset));
        piles.put("wastePile", new WastePile(6 * cardWidth + 7 * margin, margin + offset));
        piles.put("parking", new Parking(6 * cardWidth + 7 * margin, 2 * cardHeight + 3 * margin + offset));
    }

    public void dealCards(boolean fixedOrder) {
        ((Stock) piles.get("stock")).dealCards(fixedOrder);
        piles.get("wastePile").clearCards();
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
