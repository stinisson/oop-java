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
        g.setColor(super.getColor());
        g.fillRect(x-width/2, y-height/2, width, height);
    }

    @Override
    public boolean contains(int mx, int my) {
        return x-r<=mx && y-r<=my && mx <= x+r && my <= y+r;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x0, int y0) {
        x = x0;
        y = y0;
    }
}
