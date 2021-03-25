package oop.exercises.geometry;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


class MouseListener extends MouseAdapter implements MouseMotionListener {

    DrawingPanel drawingPanel;
    Figure selectedFig;
    int mx, my;
    int x, y;
    int dx, dy;

    public MouseListener (DrawingPanel p) {
        drawingPanel = p;
    }

    public void mousePressed (MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        selectedFig = drawingPanel.containsFigure(mx, my);

        if (selectedFig != null) {
            x = selectedFig.getPosition()[0];
            y = selectedFig.getPosition()[1];
            dx = x - mx;
            dy = y - my;
            drawingPanel.figures.remove(selectedFig);
            drawingPanel.figures.add(selectedFig);
            drawingPanel.moveFigure(selectedFig, mx + dx, my + dy);
        }
    }

    public void mouseDragged (MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if (selectedFig != null) {
            drawingPanel.moveFigure(selectedFig, mx + dx, my + dy);
        }
    }
}