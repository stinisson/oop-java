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

        JPanel p = new DrawingPanel(d);
        add(p);
        //setBounds(d, d,d*2,d*2);
        setBounds(d, d,d*2,d*2);
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

    int d;
    MouseListener l1 = new MouseListener();

    // figure list
    Rectangle rect = new Rectangle();
    Circle circle = new Circle();
    Triangle triangle = new Triangle();

    public DrawingPanel(Integer d) {
        this.d = d;
        setBackground(Color.PINK);
        addMouseListener(l1);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        circle.render(g, d);
        rect.render(g, d);

    }
}


class MouseListener extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
        System.out.println("Klick vid ("+e.getX() + "," + e.getY()+")");
    }
}