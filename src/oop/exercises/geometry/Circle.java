package oop.exercises.geometry;

import java.awt.*;

public class Circle extends Figure{
    @Override
    public void render(Graphics g, Integer d) {

        Color LYELLOW = new Color(253,233,130, 200) ;
        g.setColor(LYELLOW);
        g.fillOval(d-d/2, d-d/2, d/2, d/2);

    }
}
