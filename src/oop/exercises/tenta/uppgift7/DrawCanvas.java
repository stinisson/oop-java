package oop.exercises.tenta.uppgift7;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawCanvas extends JPanel { 

    public DrawCanvas() { 
        // calling factory method 
        listener = makeCanvasListener(); 
        addMouseListener(listener); 
        addMouseMotionListener(listener); 
    }

    public void setTool(Tool tool) { 
        listener.setTool(tool);
    }

    public Tool getTool() { 
        return listener.getTool(); 
    }

    public void addShape(Shape shape) {
        if (shape != null) { 
            shapes.add(shape); 
        }
    }

    public void paint(Graphics g) {
        Dimension dim = getSize(); 
        g.setColor(Color.white);
        g.fillRect(0, 0, dim.width, dim.height);    
        g.setColor(Color.black);
        if (shapes != null) { 
            Iterator iter = shapes.iterator(); 
            while (iter.hasNext()) { 
                Shape shape = (Shape) iter.next(); 
                if (shape != null) { 
                    shape.draw(g); 
                }
            }
        }
    }


    // factory method 
    private DrawCanvasListener makeCanvasListener() {
        return new DrawCanvasListener(this); 
    }

    // The list of shapes of the drawing 
    // The elements are instances of Stroke
    private List<Shape> shapes = new ArrayList<Shape>(); 

    private DrawCanvasListener listener;

    protected boolean mouseButtonDown = false; 
    protected int x, y;
}

