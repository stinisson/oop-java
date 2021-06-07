package oop.exercises.tenta.uppgift7;

import oop.exercises.geometry.Circle;

import java.awt.*;

public class OvalTool extends BilateralTool {
    public OvalTool(DrawCanvas canvas, String name, int shape) {
        super(canvas, name, shape);
    }

    @Override
    public void draw(Graphics g, int x1, int y1, int x2, int y2) {
        double r = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        g.drawOval((int) (x1-r), (int) (y1-r), (int) (2*r), (int) (2*r));
    }

    @Override
    public BilateralShape makeShape() {
        return new OvalShape();
    }
}
