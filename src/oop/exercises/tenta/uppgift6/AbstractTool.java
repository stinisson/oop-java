package oop.exercises.tenta.uppgift6;


public abstract class AbstractTool implements Tool {

    public DrawCanvas getCanvas() {
        return canvas;
    }

    public String getName() {
        return name; 
    }

    public AbstractTool(DrawCanvas canvas, String name) {
        this.canvas = canvas;
        this.name = name; 
    }

    private DrawCanvas canvas; 
    private String name;

}
