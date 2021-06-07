import java.awt.*;

public class ScribbleTool extends AbstractTool { 

    public ScribbleTool(DrawCanvas canvas, String name) {
        super(canvas, name);
    }

    public void startShape(Point p) {
        curStroke = new Stroke(); 
        curStroke.addPoint(p); 
    }

    public void addPointToShape(Point p) {
        if (curStroke != null) { 
            DrawCanvas canvas = getCanvas();
            curStroke.addPoint(p); 
            Graphics g = canvas.getGraphics();
            g.setColor(curStroke.getColor());
            g.drawLine(canvas.x, canvas.y, p.x, p.y); 
        }
    }

    public void endShape(Point p) {
        if (curStroke != null) { 
            curStroke.addPoint(p); 
            getCanvas().addShape(curStroke); 
            curStroke = null; 
        }
    }

    private Stroke curStroke = null; 
}
