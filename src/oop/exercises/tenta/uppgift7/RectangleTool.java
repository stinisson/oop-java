package oop.exercises.tenta.uppgift7;

import java.awt.*;

public class RectangleTool extends BilateralTool {
    public RectangleTool(DrawCanvas canvas, String name, int shape) {
        super(canvas, name, shape);
    }

    @Override
    public void draw(Graphics g, int x1, int y1, int x2, int y2) {
        int w = x2 - x1;
        int h = y2 - y1;

        if (w < 0) {
            x1 = x1 + w;
            w = -w;
        }
        if (h < 0) {
            y1 = y1 + h;
            h = -h;
        }
        g.drawRect(x1, y1, w, h);

    }

    @Override
    public BilateralShape makeShape() {
        return new RectangleShape();
    }
}
