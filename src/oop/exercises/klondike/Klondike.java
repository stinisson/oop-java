package oop.exercises.klondike;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Klondike extends JFrame implements ActionListener {

    private static int d = 100;
    JButton newButton;
    JButton fixButton;
    JButton exitButton;
    GameBoard gameBoard;

    public Klondike() throws IOException {
        super("Klondike");

        newButton = new JButton("New");
        fixButton = new JButton("Fix");
        exitButton = new JButton("Exit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newButton);
        buttonPanel.add(fixButton);
        buttonPanel.add(exitButton);

        gameBoard = new GameBoard();

        add(buttonPanel, BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);

        setBounds(d, d,d*8,d*6);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        newButton.addActionListener(this);
        fixButton.addActionListener(this);
        exitButton.addActionListener(this);

        gameBoard.addCardOutlines();
        gameBoard.dealCards(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newButton) {
            System.out.println("New Button clicked.");
            gameBoard.dealCards(false);
        } else if (e.getSource() == fixButton) {
            System.out.println("Fix Button clicked.");
            gameBoard.dealCards(true);
        } else if (e.getSource() == exitButton) {
            System.out.println("Exit Button clicked.");
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        try {
            Klondike klondike = new Klondike();
        } catch (IOException e) {
            System.out.println("Error, couldn't read images");
        }
    }



}
