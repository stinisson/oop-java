package oop.exercises.klondike;

import java.awt.*;

public class CardOutline {

    int x, y;

    public CardOutline(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g) {

        int width = 71;
        int height = 96;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.setColor(Color.PINK);
        g.drawRect(x, y, width, height);
    }
}
