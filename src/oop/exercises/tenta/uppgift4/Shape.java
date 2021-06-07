import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Serializable { 

    public Shape() {} 
  
    public abstract void draw(Graphics g); 

    public Color getColor() {
        return color; 
    }

    private Color color = Color.black; 
}
