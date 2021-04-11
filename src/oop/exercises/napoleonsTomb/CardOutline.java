package oop.exercises.napoleonsTomb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CardOutline {

    private final int x;
    private final int y;
    private final BufferedImage outline;

    public CardOutline(int x, int y, String pileName) {
        this.x = x;
        this.y = y;

        switch (pileName) {
            case "foundationM", "parking" ->
                    outline = readImage("/resources/images/outlines/foundation6.png");
            case "foundationLT", "foundationRT", "foundationLB", "foundationRB" ->
                    outline = readImage("/resources/images/outlines/foundation7.png");
            case "stock", "wastePile", "tableauT", "tableauB", "tableauLM", "tableauRM" ->
                    outline = readImage("/resources/images/outlines/foundation_empty.png");
            default ->
                    outline = null;
        }
    }

    private BufferedImage readImage(String path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void render(Graphics g, java.awt.image.ImageObserver observer) {
        g.drawImage(outline, x, y, observer);
    }
}
