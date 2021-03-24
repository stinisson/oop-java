package oop.exercises.geometry;

import java.awt.*;

public class Rectangle extends Figure{

    public Rectangle(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics g) {
        int width = 2*r;
        int height = 2*r;
        g.setColor(LLILAC);
        g.fillRect(x-width/2, y-height/2, width, height);
    }

    @Override
    public boolean contains(int mx, int my) {
        if (x-r<=mx && y-r<=my && mx <= x+r && my <= y+r) {
            System.out.println("CONTAINS RECTANGLE");
            return x-r<=mx && y-r<=my && mx <= x+r && my <= y+r;
        } else {
            System.out.println("No rectangle");
            return false;
        }
        //return x-r<=mx && y-r<=my && mx <= x+r && my <= y+r;
    }
}
