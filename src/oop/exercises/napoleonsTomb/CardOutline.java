package oop.exercises.napoleonsTomb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardOutline {

    int x, y;
    BufferedImage outline;

    public CardOutline(int x, int y, String pileName) {
        this.x = x;
        this.y = y;

        try {
            switch (pileName) {
                case "foundationM", "parking" ->
                        outline = ImageIO.read(new File("src/oop/exercises/napoleonsTomb/images/outlines/foundation6.png"));
                case "foundationLT", "foundationRT", "foundationLB", "foundationRB" ->
                        outline = ImageIO.read(new File("src/oop/exercises/napoleonsTomb/images/outlines/foundation7.png"));
                case "stock", "wastePile", "tableauT", "tableauB", "tableauLM", "tableauRM" ->
                        outline = ImageIO.read(new File("src/oop/exercises/napoleonsTomb/images/outlines/foundation_empty.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g, java.awt.image.ImageObserver observer) {
        g.drawImage(outline, x, y, observer);
    }
}
