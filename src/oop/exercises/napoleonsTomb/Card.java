package oop.exercises.napoleonsTomb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {

    int cardWidth = 71;
    int cardHeight = 96;
    int x, y;
    boolean isUp = false;
    BufferedImage frontImage, backImage;
    private static final String[] colors = {"c", "d", "h", "s"};
    private static final String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};
    String parentPile;

    public Card(int x, int y, int color, int value, String parentPile) {
        this.x = x;
        this.y = y;
        this.parentPile = parentPile;

        String cardValue = colors[color] + values[value];
        try {
            frontImage = ImageIO.read(new File("src/oop/exercises/klondike/images/" + cardValue + ".gif"));
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
        System.out.println("In contains: " + (mx > x && mx <= x+cardWidth && my > y && my <= y+cardHeight));
        return mx > x && mx <= x+cardWidth && my > y && my <= y+cardHeight;
    }

    public Integer[] getPosition() {
        return new Integer[]{x, y};
    }


    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
