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

        int pWidth = getWidth();
        int pHeight = getHeight();
        System.out.println(pWidth);

        int cardWidth = 71;
        int space = 30;
        int startPos = 55;

        outlines = new ArrayList<>(0);
        outlines.add(new CardOutline(startPos, 50 ));
        outlines.add(new CardOutline(startPos + space + cardWidth, 50));
        outlines.add(new CardOutline(startPos + 2*space + 2*cardWidth, 50));
        outlines.add(new CardOutline(startPos + 3*space + 3*cardWidth, 50));
        outlines.add(new CardOutline(startPos + 5*space + 5*cardWidth, 50));
        outlines.add(new CardOutline(startPos + 6*space + 6*cardWidth, 50));


        outlines.add(new CardOutline(startPos, 200 ));
        outlines.add(new CardOutline(startPos + space + cardWidth, 200));
        outlines.add(new CardOutline(startPos + 2*space + 2*cardWidth, 200));
        outlines.add(new CardOutline(startPos + 3*space + 3*cardWidth, 200));
        outlines.add(new CardOutline(startPos + 4*space + 4*cardWidth, 200));
        outlines.add(new CardOutline(startPos + 5*space + 5*cardWidth, 200));
        outlines.add(new CardOutline(startPos + 6*space + 6*cardWidth, 200));

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CardOutline outline : outlines) {
            outline.render(g);
        }

    }

}
