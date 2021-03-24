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

    ArrayList<Figure> figures;
    int mx, my;

    public DrawingPanel() {
        setBackground(Color.PINK);
        addMouseListener(this);


        MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered");
            }

            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited");
            }
        };
        addMouseListener(mouseAdapter);

        MouseAdapter mouseAdapter2 = new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                System.out.println("mouseMoved");
            }
            public void mouseDragged(MouseEvent e) {
                System.out.println("mouseDragged");
            }
        };
        addMouseListener(mouseAdapter2);
        addMouseMotionListener(mouseAdapter2);

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
        mx = e.getX();
        my = e.getY();
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
