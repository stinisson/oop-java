package oop.exercises.tenta.uppgift7;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stroke extends Shape { 

    public Stroke() {} 

    public void addPoint(Point p) {
        if (p != null) { 
            points.add(p); 
        }
    }

    public List getPoints() { 
        return points; 
    }

    public void draw(Graphics g) {
        Color color = getColor();
        if (color != null) {
            g.setColor(color);
        }
        Point prev = null; 
        Iterator iter = points.iterator(); 
        while (iter.hasNext()) { 
            Point cur = (Point) iter.next(); 
            if (prev != null) {
                g.drawLine(prev.x, prev.y, cur.x, cur.y); 
            }
            prev = cur; 
        }
    }

    // The list of points on the stroke
    // elements are instances of java.awt.Point 
    private List<Point> points = new ArrayList<Point>();  
  
}
