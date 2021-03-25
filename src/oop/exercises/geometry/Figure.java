package oop.exercises.geometry;

import java.awt.*;

abstract class Figure {
    static int h =  100;
    static int r = h/2;
    Color LYELLOW = new Color(253,233,130, 255);
    Color LBLUE = new Color(104,212,249, 255);
    Color LGREEN = new Color(174,241,182, 255);
    Color LORANGE = new Color(255,205,165, 255);
    Color LLILAC = new Color(240,220,240, 255);
    Color DRED = new Color(227,89,81, 255);
    Color DBLUE = new Color(51,151,211, 255);
    Color DGREEN = new Color(35,180,126, 255);
    Color DORANGE = new Color(246,155,90, 255);
    Color DLILAC = new Color(183,107,196, 255);
    Color[] colors;
    int colorIdx;
    int x, y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
        colors = new Color[10];
        colors[0] = LYELLOW;
        colors[1] = LBLUE;
        colors[2] = LGREEN;
        colors[3] = LORANGE;
        colors[4] = LLILAC;
        colors[5] = DRED;
        colors[6] = DBLUE;
        colors[7] = DGREEN;
        colors[8] = DORANGE;
        colors[9] = DLILAC;
        colorIdx = (int) (Math.random() * colors.length);
    }

    public Color getColor() {
        return colors[colorIdx];
    }

    abstract public void render(Graphics g);

    abstract public boolean contains(int mx, int my);

    abstract public void setPosition(int x, int y);

    abstract public void move(int x, int y);
}
