package oop.exercises.klondike;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


class MouseListener extends MouseAdapter implements MouseMotionListener {

    GameBoard gameBoard;
    Card selectedCard;
    int mx, my;
    int x, y;
    int dx, dy;

    public MouseListener (GameBoard gb) {
        gameBoard = gb;
    }

    public void mousePressed (MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        selectedCard = gameBoard.containsCard(mx, my);

        if (selectedCard != null) {
            x = selectedCard.getPosition()[0];
            y = selectedCard.getPosition()[1];
            dx = x - mx;
            dy = y - my;
            //gameBoard.figures.remove(selectedCard);
            //gameBoard.figures.add(selectedCard);
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
        System.out.println("Click at " + mx + " " + my);
        gameBoard.stockAction(mx, my);
    }
}