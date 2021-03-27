package oop.exercises.klondike;

import java.awt.*;

public class Card {

    int x, y;

    public Card(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g) {
        int width = 71;
        int height = 96;
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
