package oop.exercises.klondike;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard extends JPanel {

    ArrayList<CardOutline> outlines;


    public GameBoard() {
        setBackground(Color.GREEN);
    }

    public void addCardOutlines() {

        outlines = new ArrayList<>(0);
        outlines.add(new CardOutline(50, 50 ));
        outlines.add(new CardOutline(141, 50));
        outlines.add(new CardOutline(232, 50));
        outlines.add(new CardOutline(323, 50));
        outlines.add(new CardOutline(588, 50));
        outlines.add(new CardOutline(679, 50));

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CardOutline outline : outlines) {
            outline.render(g);
        }

    }

}
