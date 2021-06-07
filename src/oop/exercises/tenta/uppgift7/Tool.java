package oop.exercises.tenta.uppgift7;

import java.awt.*;

public interface Tool { 

    public String getName(); 
    public void startShape(Point p); 
    public void addPointToShape(Point p);
    public void endShape(Point p); 

}
