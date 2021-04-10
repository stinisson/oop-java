package oop.exercises.napoleonsTomb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {

    static final int width = 71;
    static final int height = 96;
    int x, y;
    boolean isUp = false;
    BufferedImage frontImage, backImage;
    private static final String[] colors = {"c", "d", "h", "s"};
    private static final String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};
    String parentPile;
    private final int cardValue;
    private final String cardColor;

    public Card(int x, int y, int color, int value, String parentPile) {
        this.x = x;
        this.y = y;
        cardValue = value + 1;
        cardColor = colors[color];
        this.parentPile = parentPile;

        String cardName = colors[color] + values[value];

        try {
            frontImage = ImageIO.read(new File("src/oop/exercises/klondike/images/" + cardName + ".gif"));
            backImage = ImageIO.read(new File("src/oop/exercises/klondike/images/b1fv.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g, java.awt.image.ImageObserver observer) {
        if (isUp) {
            g.drawImage(frontImage, x, y, observer);
        } else {
            g.drawImage(backImage, x, y, observer);
        }
    }

    public boolean contains(int mx, int my) {
        return mx > x && mx <= x+ width && my > y && my <= y+ height;
    }

    public Integer[] getPosition() {
        return new Integer[]{x, y};
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setParent(String parent) {
        parentPile = parent;
    }
}
