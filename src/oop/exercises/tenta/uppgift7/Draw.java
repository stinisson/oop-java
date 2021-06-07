package oop.exercises.tenta.uppgift7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Draw extends JFrame { 

    public Draw(String title) {
        super(title); 
        getContentPane().setLayout(new BorderLayout()); 
        initTools();
        menuBar = createMenuBar(); 
        getContentPane().add(menuBar, BorderLayout.NORTH); 
        getContentPane().add(canvas, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu; 
        JMenuItem mi;

        // Tool menu
        ActionListener toolListener = new ActionListener() { 
                public void actionPerformed(ActionEvent event) { 
                    Object source = event.getSource();
                    if (source instanceof AbstractButton) {
                        AbstractButton button = (AbstractButton) source; 
                        Tool tool = toolkit.setSelectedTool(button.getText());
                        canvas.setTool(tool);
                    }
                }
            };       
        menu = createToolMenu(toolListener); 
        menuBar.add(menu); 

        // horizontal space 
        menuBar.add(Box.createHorizontalGlue());

        // Help menu 
        menu = new JMenu("Help"); 
        menuBar.add(menu); 

        mi = new JMenuItem("About");
        menu.add(mi);
        mi.addActionListener(new AboutListener()); 

        return menuBar; 
    }

    public Tool getSelectedTool() { 
        return toolkit.getSelectedTool(); 
    }

    private void initTools() { 
        toolkit = new ToolKit(); 
        toolkit.addTool(new ScribbleTool(canvas, "Scribble")); 
        toolkit.addTool(new LineTool(canvas, "Line", BilateralTool.LINE));
        //toolkit.addTool(new BilateralTool(canvas, "Oval", BilateralTool.OVAL));
        toolkit.addTool(new OvalTool(canvas, "Circle", BilateralTool.OVAL));

        toolkit.addTool(new RectangleTool(canvas, "Rectangle", BilateralTool.RECT));
        canvas.setTool(toolkit.getTool(0));
    }

    private JMenu createToolMenu(ActionListener toolListener) { 
        JMenu menu = new JMenu("Tools"); 
        int n = toolkit.getToolCount(); 
        for (int i = 0; i < n; i++) {
            Tool tool = toolkit.getTool(i); 
            if (tool != null) { 
                JMenuItem menuitem = new JMenuItem(tool.getName());
                menuitem.addActionListener(toolListener); 
                menu.add(menuitem);
            }
        }
        return menu; 
    }

    class AboutListener implements ActionListener { 
    
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(
            null, 
            "DrawingPad version 1.0\nCopyright (c)Hia 2022", "About", 
            JOptionPane.INFORMATION_MESSAGE); 
        }
    }

    private DrawCanvas canvas = new DrawCanvas(); 

    private JMenuBar menuBar; 

    private static int width = 600; 
    private static int height = 400; 

    private ToolKit toolkit;

    public static void main(String[] args) {
        JFrame frame = new Draw("Draw");
        frame.setSize(width, height);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screenSize.width/2 - width/2,
                          screenSize.height/2 - height/2);
        frame.setVisible(true);
    }
}
