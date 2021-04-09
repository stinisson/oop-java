package oop.exercises.napoleonsTomb;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class GameBoard extends JPanel {

    boolean resourcesLoaded = false;
    HashMap<String, Pile> piles;
    Card movingCard;

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

        if (movingCard != null) {
            movingCard.render(g, this);
        }

    }

    public void stockAction(int mx, int my) {
        if (piles.get("stock").isEmpty()) {
            return;
        }

        if (piles.get("stock").getTopCard().contains(mx, my)) {
            Card wasteCard = piles.get("stock").getTopCard();
            wasteCard.parentPile = "wastePile";
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
        piles.put("foundationLT", new Foundation7(cardWidth + 2 * margin - offset, margin, "foundationLT"));
        piles.put("foundationRT", new Foundation7(3 * cardWidth + 4 * margin + offset, margin, "foundationRT"));
        piles.put("foundationLB", new Foundation7(cardWidth + 2 * margin - offset, 2 * cardHeight + 3 * margin + 2 * offset, "foundationLB"));
        piles.put("foundationRB", new Foundation7(3 * cardWidth + 4 * margin + offset, 2 * cardHeight + 3 * margin + 2 * offset, "foundationRB"));
        piles.put("foundationM", new Foundation6(2 * cardWidth + 3 * margin, cardHeight+ 2 * margin + offset, "foundationM"));
        piles.put("tableauT", new Tableau(2 * cardWidth + 3 * margin, margin + offset, "tableauT"));
        piles.put("tableauLM", new Tableau(cardWidth + 2 * margin, cardHeight+ 2 * margin + offset, "tableauLM"));
        piles.put("tableauRM", new Tableau(3 * cardWidth + 4 * margin, cardHeight+ 2 * margin + offset, "tableauRM"));
        piles.put("tableauB", new Tableau(2 * cardWidth + 3 * margin, 2 * cardHeight + 3 * margin + offset, "tableauB"));
        piles.put("stock", new Stock(5 * cardWidth + 6 * margin, margin + offset, "stock"));
        piles.put("wastePile", new WastePile(6 * cardWidth + 7 * margin, margin + offset, "wastePile"));
        piles.put("parking", new Parking(6 * cardWidth + 7 * margin, 2 * cardHeight + 3 * margin + offset, "parking"));
    }

    public void dealCards(boolean fixedOrder) {
        ((Stock) piles.get("stock")).dealCards(fixedOrder);
        piles.get("wastePile").clearCards();
        resourcesLoaded = true;
        repaint();
    }



    public Card containsCard(int mx, int my) {

        for (Pile pile : piles.values()) {
            if (!pile.isEmpty() && !pile.getName().equals("stock")) {
                if (pile.getTopCard().contains(mx, my)) {
                    return pile.getTopCard();
                }
            }

        }


/*        if (!piles.get("wastePile").isEmpty()) {
            if (piles.get("wastePile").getTopCard().contains(mx, my)) {
                return piles.get("wastePile").getTopCard();
            }
        }*/

        return null;
    }

    public void moveCard(Card card, int mx, int my) {
            movingCard = card;
            card.move(mx, my);
            repaint();
    }


    public void dropCard() {
        if (movingCard == null) {
            return;
        }

        for (Pile pile : piles.values()) {
            if (pile.put(movingCard)) {
                movingCard = null;
                repaint();
                return;
            }
        }

        piles.get(movingCard.parentPile).addCard(movingCard);
        movingCard = null;
        repaint();
    }




}
