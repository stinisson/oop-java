package oop.exercises.geometry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Geometry extends JFrame{
    private static int d = 100;

    public Geometry() {
        super("Geometry Tip Tap");
        geometryPanel();
    }

    public void geometryPanel() {
        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel);
        setBounds(d, d,d*6,d*6);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println("close");
        setVisible(true);
        drawingPanel.addFigures();
    }

    public static void main(String args[]) {
        Geometry geometry = new Geometry();
    }
}


class DrawingPanel extends JPanel implements MouseListener{

    // figure list
    /*Rectangle rect = new Rectangle();
    Circle circle = new Circle();*/
    //Triangle triangle = new Triangle(pWidth/2, pHeight/2);

    ArrayList<Figure> figures;

    public DrawingPanel() {
        // KOLLA UPP
        //super();
        setBackground(Color.PINK);
        addMouseListener(this);
    }

    public void addFigures() {
        int pWidth = getWidth();
        int pHeight = getHeight();

        figures = new ArrayList<Figure>(0);
        figures.add(new Circle(pWidth/4, pHeight/4));
        figures.add(new Rectangle(pWidth*3/4, pHeight/4));
        figures.add(new Triangle(pWidth/2, pHeight/2));
        figures.add(new Rectangle(pWidth/4, pHeight*3/4));
        figures.add(new Circle(pWidth*3/4, pHeight*3/4));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figure figure : figures) {
            figure.render(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        System.out.println("Klick vid ("+e.getX() + "," + e.getY()+")");
        for (Figure figure : figures) {
            figure.contains(mx, my);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
