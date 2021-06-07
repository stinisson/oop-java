package oop.exercises.tenta.uppgift7;

import java.awt.*;

public class OvalShape extends BilateralShape {

    public void draw(Graphics g) {
/*
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2); 
        int w = Math.abs(x1 - x2) + 1; 
        int h = Math.abs(y1 - y2) + 1;
        g.drawOval(x, y, w, h);
*/

        double r = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        g.drawOval((int) (x1-r), (int) (y1-r), (int) (2*r), (int) (2*r));
    }

    public void drawOutline(Graphics g, int x1, int y1, int x2, int y2) {
        /*int x = Math.min(x1, x2);
        int y = Math.min(y1, y2); 
        int w = Math.abs(x1 - x2) + 1; 
        int h = Math.abs(y1 - y2) + 1;     
        g.drawOval(x, y, w, h);*/
    }
}
