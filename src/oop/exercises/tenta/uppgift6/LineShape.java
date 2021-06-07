package oop.exercises.tenta.uppgift6;

import java.awt.*;

public class LineShape extends BilateralShape {

    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2); 
    }

    public void drawOutline(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2); 
    }

}
