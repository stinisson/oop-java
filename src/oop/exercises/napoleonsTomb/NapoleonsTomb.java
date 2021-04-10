package oop.exercises.napoleonsTomb;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NapoleonsTomb extends JFrame implements ActionListener {

    JButton newButton;
    JButton fixButton;
    JButton exitButton;
    GameBoard gameBoard;
    public int windowWidth = 812;
    public int windowHeight = 571;

    public NapoleonsTomb() throws IOException {
        super("Napoleon's Tomb");

        newButton = new JButton("New game");
        fixButton = new JButton("Fixed order");
        exitButton = new JButton("Exit");

        Dimension buttonDimension = new Dimension(100, 26);
        newButton.setPreferredSize(buttonDimension);
        fixButton.setPreferredSize(buttonDimension);
        exitButton.setPreferredSize(buttonDimension);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newButton);
        buttonPanel.add(fixButton);
        buttonPanel.add(exitButton);

        gameBoard = new GameBoard();

        add(buttonPanel, BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);
        Color darkGreen = new Color(6, 95, 69, 255);
        buttonPanel.setBackground(darkGreen);

        int d = 100;
        setBounds(d, d, windowWidth, windowHeight);
        //setBounds(d, d,d*8, d*5);
        //setBounds(d, d, d *8+12, d *5+71);
        // diff width = 12, diff height = 71
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        newButton.addActionListener(this);
        fixButton.addActionListener(this);
        exitButton.addActionListener(this);

        gameBoard.setUpBoard();
        gameBoard.dealCards(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newButton) {
            gameBoard.dealCards(false);
        } else if (e.getSource() == fixButton) {
            gameBoard.dealCards(true);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        try {
            NapoleonsTomb napoleonsTomb = new NapoleonsTomb();
        } catch (IOException e) {
            System.out.println("Error, couldn't read images");
        }
    }



}
