package oop.exercises.tenta.uppgift7;

import java.awt.*;

public abstract class BilateralTool extends AbstractTool {

    public static final int LINE = 0; 
    public static final int OVAL = 1; 
    public static final int RECT = 2; 

    public BilateralTool(DrawCanvas canvas, String name, int shape) {
        super(canvas, name);
        this.shape = shape; 
    }
 
    public void startShape(Point p) {
        DrawCanvas canvas = getCanvas();
        canvas.mouseButtonDown = true;
        xStart = canvas.x = p.x; 
        yStart = canvas.y = p.y; 
        Graphics g = canvas.getGraphics();
        g.setXORMode(Color.darkGray); 
        g.setColor(Color.red);
        draw(g, xStart, yStart, xStart, yStart);

        /*switch (shape) {
        case LINE:
            drawLine(g, xStart, yStart, xStart, yStart); 	       
            break; 
        case OVAL:
            drawOval(g, xStart, yStart, xStart+1, yStart+1);
            break; 
        case RECT:
            drawRect(g, xStart, yStart, 1, 1); 
            break; 
        }*/
    }

    public void addPointToShape(Point p) {
        DrawCanvas canvas = getCanvas();
        if (canvas.mouseButtonDown) {
            Graphics g = canvas.getGraphics();
            g.setXORMode(Color.darkGray); 
            g.setColor(Color.green);
            draw(g, xStart, yStart, canvas.x, canvas.y);
            draw(g, xStart, yStart, p.x, p.y);

            /*switch (shape) {
            case LINE:
                drawLine(g, xStart, yStart, canvas.x, canvas.y); 
                drawLine(g, xStart, yStart, p.x, p.y); 
                break; 
            case OVAL:
                *//* drawOval(g, xStart, yStart,
                         canvas.x - xStart + 1, canvas.y - yStart + 1); 
                drawOval(g, xStart, yStart, 
                         p.x - xStart + 1, p.y - yStart + 1);
                *//*

                drawOval(g, xStart, yStart, canvas.x, canvas.y);
                drawOval(g, xStart, yStart, p.x, p.y);
                break; 
            case RECT:
                drawRect(g, xStart, yStart, 
                         canvas.x - xStart + 1, canvas.y - yStart + 1);  
                drawRect(g, xStart, yStart, 
                         p.x - xStart + 1, p.y - yStart + 1); 
                break; 
            }*/
            canvas.x = p.x; 
            canvas.y = p.y; 
        } 
    }

    public void endShape(Point p) {
        DrawCanvas canvas = getCanvas();
        canvas.mouseButtonDown = false; 
        BilateralShape newShape = null;
        newShape = makeShape();

        /*switch (shape) {
        case LINE:
            newShape = new LineShape(); 
            break; 
        case OVAL:
            newShape = new OvalShape(); 
            break;
        case RECT:
            newShape = new RectangleShape(); 
        }*/
        if (newShape != null) { 
            newShape.setEnds(xStart, yStart, p.x, p.y); 
            canvas.addShape(newShape);
        } 
        Graphics g = canvas.getGraphics();
        g.setPaintMode();
        canvas.repaint();
    }

    protected int shape = LINE; 
    protected int xStart, yStart;

    public abstract void draw(Graphics g, int x1, int y1, int x2, int y2);
    public abstract BilateralShape makeShape();

/*
    // helper methods 
    public static void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2); 
    } 

    public static void drawRect(Graphics g, int x, int y, int w, int h) {
        if (w < 0) {
            x = x + w; 
            w = -w; 
        }
        if (h < 0) {
            y = y + h;
            h = -h;
        }
        g.drawRect(x, y, w, h); 
    }
  
    public static void drawOval(Graphics g, int x1, int y1, int x2, int y2) {

        double r = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        g.drawOval((int) (x1-r), (int) (y1-r), (int) (2*r), (int) (2*r));
    } 
*/

}
