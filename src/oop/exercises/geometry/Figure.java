package oop.exercises.geometry;

import java.awt.*;


abstract class Figure {
    protected static final int h =  100;
    protected static final int r = h/2;

    private final Color[] colors;
    private final int colorIdx;

    protected int x, y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;

        colors = new Color[10];
        colors[0] = new Color(253,233,130, 255);
        colors[1] = new Color(104,212,249, 255);
        colors[2] = new Color(174,241,182, 255);
        colors[3] = new Color(255,205,165, 255);
        colors[4] = new Color(240,220,240, 255);
        colors[5] = new Color(227,89,81, 255);
        colors[6] = new Color(51,151,211, 255);
        colors[7] = new Color(35,180,126, 255);
        colors[8] = new Color(246,155,90, 255);
        colors[9] = new Color(183,107,196, 255);
        colorIdx = (int) (Math.random() * colors.length);
    }

    public Color getColor() {
        return colors[colorIdx];
    }

    abstract public void render(Graphics g);

    abstract public boolean contains(int mx, int my);

    abstract public void move(int x, int y);

    abstract public Integer[] getPosition();
}
