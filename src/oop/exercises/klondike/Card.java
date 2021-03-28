package oop.exercises.klondike;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {

    int x, y;
    boolean isUp = false;
    BufferedImage frontImage, backImage;

    public Card(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            frontImage = ImageIO.read(new File("src/oop/exercises/klondike/images/c1.gif"));
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
}
