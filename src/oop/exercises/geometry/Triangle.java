package oop.exercises.geometry;

import java.awt.*;


public class Triangle extends Figure{

    public Triangle(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics g) {
        int[] XPoints  = {x, x+h/2, x-h/2};
        int[] YPoints   = {y-h/2, y+h/2, y+h/2};
        g.setColor(super.getColor());
        g.fillPolygon(XPoints, YPoints, 3);
    }

    @Override
    public boolean contains(int mx, int my) {
        int dx = mx-x;
        int dy = my-y+h/2;
        return -dy <= 2*dx && 2*dx <= dy && dy <= h;
    }

    @Override
    public Integer[] getPosition() {
        return new Integer[]{x, y};
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
