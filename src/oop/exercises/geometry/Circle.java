package oop.exercises.geometry;

import java.awt.*;

public class Circle extends Figure{
    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics g) {
        int width = 2*r;
        int height = 2*r;
        g.setColor(super.getColor());
        g.fillOval(x-width/2, y-height/2, width, height);

    }

    @Override
    public boolean contains(int mx, int my) {
        if ((x-mx)*(x-mx)+(y-my)*(y-my) <= r*r) {
            System.out.println("CONTAINS CIRCLE");
            return (x-mx)*(x-mx)+(y-my)*(y-my) <= r*r;
        } else {
            System.out.println("No circle");
            return false;
        }
        //return (cx-x)*(cx-x)+(cy-y)*(cy-y) <= r*r;
    }
}
