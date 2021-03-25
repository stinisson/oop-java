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




class DrawingPanel extends JPanel {

    ArrayList<Figure> figures;

    public DrawingPanel() {
        setBackground(Color.PINK);
        MouseListener ml = new MouseListener(this);
        addMouseListener (ml);
        addMouseMotionListener(ml);
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

    public Figure containsFigure(int mx, int my) {

        for (int i = figures.size()-1; i >= 0; i--) {
            if (figures.get(i).contains(mx, my)) {
                return figures.get(i);
            }
        }
        return null;
    }

    public void moveFigure(Figure figure, int x, int y) {
        figure.move(x, y);
        repaint();
    }

}

class MouseListener extends MouseAdapter implements MouseMotionListener {

    DrawingPanel drawingPanel;
    Figure selectedFig;

    public MouseListener (DrawingPanel p) {
        drawingPanel = p;
    }

    public void mouseClicked (MouseEvent e) {
        System.out.println("Klick vid ("+e.getX() + "," + e.getY()+")");
    }

    public void mousePressed (MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        selectedFig = drawingPanel.containsFigure(mx, my);
    }

    public void mouseDragged (MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (selectedFig != null) {
            drawingPanel.moveFigure(selectedFig, mx, my);
            int fidIdx = drawingPanel.figures.indexOf(selectedFig);
            drawingPanel.figures.remove(fidIdx);
            drawingPanel.figures.add(selectedFig);
        }
    }
}

// mx my
// setPosition(x, y)
// dx = mx - x
// dy = my - y
// x += dx
// y += dy
