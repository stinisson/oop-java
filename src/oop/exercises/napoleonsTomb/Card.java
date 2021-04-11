package oop.exercises.napoleonsTomb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {

    public static final int width = 71;
    public static final int height = 96;
    private int x;
    private int y;
    private boolean isUp = false;
    private final BufferedImage frontImage, backImage;
    private static final String[] colors = {"c", "d", "h", "s"};
    private static final String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};
    private String parentPileName;
    private final int value;

    public Card(int x, int y, int color, int value, String parentPile) {
        this.x = x;
        this.y = y;
        this.value = value + 1;
        this.parentPileName = parentPile;

        String cardName = colors[color] + values[value];
        frontImage = readImage("src/oop/exercises/napoleonsTomb/images/" + cardName + ".gif");
        backImage = readImage("src/oop/exercises/napoleonsTomb/images/b1fv.gif");
    }

    private BufferedImage readImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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
        return mx > x && mx <= x + width && my > y && my <= y + height;
    }

    public Integer[] getPosition() {
        return new Integer[]{x, y};
    }

    public int getCardValue() {
        return value;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setParent(String parent) {
        parentPileName = parent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setIsUp(boolean isUp) {
        this.isUp = isUp;
    }

    public String getParentPileName() {
        return parentPileName;
    }

    public void setParentPileName(String parentPileName) {
        this.parentPileName = parentPileName;
    }
}
