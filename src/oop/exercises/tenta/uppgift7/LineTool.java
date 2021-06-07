package oop.exercises.tenta.uppgift7;

import java.awt.*;

public class LineTool extends BilateralTool {

    public LineTool(DrawCanvas canvas, String name, int shape) {
        super(canvas, name, shape);
    }

    @Override
    public void draw(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public BilateralShape makeShape() {
        return new LineShape();
    }
}
