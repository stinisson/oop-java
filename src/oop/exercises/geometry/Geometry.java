package oop.exercises.geometry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Geometry extends JFrame{
    private static int d = 200;

    public Geometry() {
        //super("Topp tipp");
        geometryPanel();

    }

    public void geometryPanel() {
        //JFrame f = new JFrame();

        JPanel p = new DrawingPanel();
        add(p);
        setBounds(d,d,d*4,d*2);
        setTitle("Geometry Tap");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println("close");
        setVisible(true);
    }

    public static void main(String args[]) {
        Geometry geometry = new Geometry();
    }
}

class DrawingPanel extends JPanel {

    MouseListener l1 = new MouseListener();
    public DrawingPanel() {
        setBackground(Color.PINK);
        addMouseListener(l1);
    }
}


class MouseListener extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
        System.out.println("Klick vid ("+e.getX() + "," + e.getY()+")");
    }
}