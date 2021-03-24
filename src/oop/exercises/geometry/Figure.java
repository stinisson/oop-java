package oop.exercises.geometry;

import java.awt.*;

abstract class Figure {
    static int h =  100;
    static int r = h/2;
    Color LYELLOW = new Color(253,233,130, 200);
    Color LBLUE = new Color(104,212,249, 200);
    Color LGREEN = new Color(174,241,182, 200);
    Color LORANGE = new Color(255,205,165, 200);
    Color LLILAC = new Color(255,199,238, 200);
    Color[] colors;
    int colorIdx;
    int x, y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
        colors = new Color[5];
        colors[0] = LYELLOW;
        colors[1] = LBLUE;
        colors[2] = LGREEN;
        colors[3] = LORANGE;
        colors[4] = LLILAC;
        colorIdx = (int) (Math.random() * colors.length);
    }

    public Color getColor() {
        return colors[colorIdx];
    }

    abstract public void render(Graphics g);

    abstract public boolean contains(int mx, int my);
}
