package oop.exercises.napoleonsTomb;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class GameBoard extends JPanel {

    boolean resourcesLoaded = false;
    HashMap<String, Pile> piles;
    Card movingCard;
    int stockRoundCount;
    private Animation winAnimation;
    private static final String[] tableauNames = {"tableauT", "tableauLM", "tableauRM", "tableauB"};

    public GameBoard() {
        setBackground(new Color(8, 120, 85, 255));
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

        if (winAnimation != null) {
            winAnimation.render(g, this);
        }

    }

    public void stockAction(int mx, int my) {
        if (!tableauIsFilled() && !piles.get("wastePile").isEmpty()) {
            return;
        }

        if (piles.get("stock").isEmpty()) {
            if (stockRoundCount > 0) {
                stockRoundCount =- 1;
                while (!piles.get("wastePile").isEmpty()) {
                    Card wasteCard = piles.get("wastePile").getTopCard();
                    piles.get("wastePile").removeTopCard();
                    wasteCard.setParent("stock");
                    piles.get("stock").addCard(wasteCard, false);
                }
            }
            return;
        }

        if (piles.get("stock").getTopCard().contains(mx, my)) {
            Card wasteCard = piles.get("stock").getTopCard();
            piles.get("stock").removeTopCard();
            wasteCard.parentPile = "wastePile";
            piles.get("wastePile").addCard(wasteCard, true);
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
        stockRoundCount = 1; // reset stock count
        for (Pile pile : piles.values()) {
            pile.clearCards();
        }
        ((Stock) piles.get("stock")).dealCards(fixedOrder);

        for (String tableau : tableauNames) {
            Card dealCard = piles.get("stock").getTopCard();
            piles.get("stock").removeTopCard();
            dealCard.parentPile = tableau;
            piles.get(tableau).addCard(dealCard, true);
        }
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
                checkWin();
                repaint();
                return;
            }
        }
        piles.get(movingCard.parentPile).addCard(movingCard, true);
        movingCard = null;
        repaint();
    }

    public boolean tableauIsFilled() {
        // One out of the four tableau is is allowed to be empty. It will not be possible to get another card from the
        // stock (unless wastepile is empty) when more than 1/4 tableau is empty.
        int numEmptyTableau = 0;
        for (String tableauName : tableauNames) {
            if (piles.get(tableauName).isEmpty()) {
                numEmptyTableau += 1;
            }
        }
        return numEmptyTableau <= 1;
    }

    public boolean checkWin() {
        if (piles.get("stock").isEmpty() && piles.get("wastePile").isEmpty()
                && piles.get("tableauT").isEmpty() && piles.get("tableauLM").isEmpty()
                && piles.get("tableauRM").isEmpty() && piles.get("tableauB").isEmpty()
                && piles.get("parking").isEmpty()) {
            System.out.println("Hipp hipp you have won!");

            winAnimation = new Animation();
            winAnimation.addPiles(piles);
            for (Pile pile : piles.values()) {
                pile.clearCards();
            }
            new Thread(() -> {
                runAnimation();
            }).start();
            return true;
        }
        System.out.println("In has won, haven't won yet. Not all piles are empty!");
        return false;
    }

    private void runAnimation() {
        while (winAnimation.step()) {
            repaint();
        }
    }
}
