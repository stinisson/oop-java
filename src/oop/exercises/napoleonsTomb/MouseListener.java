package oop.exercises.napoleonsTomb;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


class MouseListener extends MouseAdapter implements MouseMotionListener {

    private final GameBoard gameBoard;
    private Card selectedCard;
    private int mx, my;
    private int dx, dy;

    public MouseListener (GameBoard gb) {
        gameBoard = gb;
    }

    public void mousePressed (MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        selectedCard = gameBoard.containsCard(mx, my);

        if (selectedCard != null) {
            dx = selectedCard.getPosition()[0] - mx;
            dy = selectedCard.getPosition()[1] - my;
            gameBoard.getPile(selectedCard.getParentPileName()).removeTopCard();
            gameBoard.moveCard(selectedCard, mx + dx, my + dy);
        }
    }

    public void mouseDragged (MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if (selectedCard != null) {
            gameBoard.moveCard(selectedCard, mx + dx, my + dy);
        }
    }

    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        gameBoard.stockAction(mx, my);
    }

    public void mouseReleased(MouseEvent e) {
        gameBoard.dropCard();
    }
}