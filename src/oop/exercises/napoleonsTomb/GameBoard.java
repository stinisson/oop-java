package oop.exercises.napoleonsTomb;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class GameBoard extends JPanel {

    private static final String[] tableauNames = {"tableauT", "tableauLM", "tableauRM", "tableauB"};
    private static final Color backgroundColor = new Color(8, 120, 85, 255);
    private static final int numCols = 7;
    private static final int topOffset = 20;

    private boolean resourcesLoaded = false;
    private int stockRoundCount;
    private Card movingCard;
    private Animation winAnimation;
    private final HashMap<String, Pile> piles = new HashMap<>();

    public GameBoard() {
        setBackground(backgroundColor);
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
            wasteCard.setParentPileName("wastePile");
            piles.get("wastePile").addCard(wasteCard, true);
            repaint();
        }
    }

    public void setUpBoard() {
        int pWidth = getWidth();
        int margin = (pWidth - numCols * Card.width) / 8;

        piles.put("foundationLT", new Foundation7(Card.width + 2 * margin - topOffset, margin, "foundationLT"));
        piles.put("foundationRT", new Foundation7(3 * Card.width + 4 * margin + topOffset, margin, "foundationRT"));
        piles.put("foundationLB", new Foundation7(Card.width + 2 * margin - topOffset, 2 * Card.height + 3 * margin + 2 * topOffset, "foundationLB"));
        piles.put("foundationRB", new Foundation7(3 * Card.width + 4 * margin + topOffset, 2 * Card.height + 3 * margin + 2 * topOffset, "foundationRB"));
        piles.put("foundationM", new Foundation6(2 * Card.width + 3 * margin, Card.height+ 2 * margin + topOffset, "foundationM"));
        piles.put("tableauT", new Tableau(2 * Card.width + 3 * margin, margin + topOffset, "tableauT"));
        piles.put("tableauLM", new Tableau(Card.width + 2 * margin, Card.height+ 2 * margin + topOffset, "tableauLM"));
        piles.put("tableauRM", new Tableau(3 * Card.width + 4 * margin, Card.height+ 2 * margin + topOffset, "tableauRM"));
        piles.put("tableauB", new Tableau(2 * Card.width + 3 * margin, 2 * Card.height + 3 * margin + topOffset, "tableauB"));
        piles.put("stock", new Stock(5 * Card.width + 6 * margin, margin + topOffset, "stock"));
        piles.put("wastePile", new WastePile(6 * Card.width + 7 * margin, margin + topOffset, "wastePile"));
        piles.put("parking", new Parking(6 * Card.width + 7 * margin, 2 * Card.height + 3 * margin + topOffset, "parking"));
    }

    public void dealCards(boolean fixedOrder) {
        stockRoundCount = 1; // reset stock count - possible to turn stock once
        for (Pile pile : piles.values()) {
            pile.clearCards();
        }
        ((Stock) piles.get("stock")).dealCards(fixedOrder);

        for (String tableau : tableauNames) {
            Card dealCard = piles.get("stock").getTopCard();
            piles.get("stock").removeTopCard();
            dealCard.setParentPileName(tableau);
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
        // If card not dropped on/accepted by pile, return to source
        piles.get(movingCard.getParentPileName()).addCard(movingCard, true);
        movingCard = null;
        repaint();
    }

    public boolean tableauIsFilled() {
        // One out of the four tableau is allowed to be empty. It will not be possible to get another card from the
        // stock (unless wastepile is empty) when more than 1/4 tableau is empty.
        int numEmptyTableau = 0;
        for (String tableauName : tableauNames) {
            if (piles.get(tableauName).isEmpty()) {
                numEmptyTableau += 1;
            }
        }
        return numEmptyTableau <= 1;
    }

    public void checkWin() {
        if (piles.get("stock").isEmpty() && piles.get("wastePile").isEmpty()
                && piles.get("tableauT").isEmpty() && piles.get("tableauLM").isEmpty()
                && piles.get("tableauRM").isEmpty() && piles.get("tableauB").isEmpty()
                && piles.get("parking").isEmpty()) {

            int boardHeight = getHeight();
            winAnimation = new Animation(boardHeight);
            winAnimation.addPiles(piles);
            for (Pile pile : piles.values()) {
                pile.clearCards();
            }
            new Thread(this::runAnimation).start();
        }
    }

    private void runAnimation() {
        while (winAnimation.step()) {
            repaint();
        }
    }

    public Pile getPile(String name) {
        return piles.get(name);
    }
}
