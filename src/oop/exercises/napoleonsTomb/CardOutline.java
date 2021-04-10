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

        if (pileName.equals("foundationM")) {
            try {
                outline = ImageIO.read(new File("src/oop/exercises/napoleonsTomb/images/outlines/foundation6.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void render(Graphics g, java.awt.image.ImageObserver observer) {
/*        int width = 71;
        int height = 96;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.setColor(Color.PINK);
        g.drawRect(x, y, width, height);*/


        g.drawImage(outline, x, y, observer);

    }
}
