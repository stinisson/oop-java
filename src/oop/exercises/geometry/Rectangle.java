package oop.exercises.geometry;

import java.awt.*;

public class Rectangle extends Figure{

    @Override
    public void render(Graphics g, Integer d) {
        Color LBLUE = new Color(104,212,249, 200);
        Color LGREEN = new Color(174,241,182, 200);
        Color LRED = new Color(255,199,238, 200);

        g.setColor(LBLUE);
        g.fillRect(50, 50, 100, 200);

        g.setColor(LGREEN);
        g.fillRect(150,150, 60, 60);

        g.setColor(LRED);
        g.fillRect(250,250, 60, 60);
    }



}
