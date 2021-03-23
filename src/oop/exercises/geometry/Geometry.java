package oop.exercises.geometry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Geometry {
    private static int d = 200;

    public Geometry() {
        geometryPanel();
    }

    public void geometryPanel() {
        JFrame f = new JFrame();
        JPanel p = new DrawingPanel();
        f.add(p);
        f.setBounds(d,d,d*4,d*2);

        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        System.out.println("close");
        f.setVisible(true);
    }

    public static void main(String args[]) {
        Geometry geometry = new Geometry();
    }
}

class DrawingPanel extends JPanel {

    public DrawingPanel() {
        setBackground( Color.PINK );
    }
}
