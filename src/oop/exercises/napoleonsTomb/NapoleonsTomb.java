package oop.exercises.napoleonsTomb;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NapoleonsTomb extends JFrame implements ActionListener {

    private static int d = 100;
    JButton newButton;
    JButton fixButton;
    JButton exitButton;
    GameBoard gameBoard;

    public NapoleonsTomb() throws IOException {
        super("Napoleon's Tomb");

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

        setBounds(d, d,d*8+12, d*5+71);
        // diff width = 12, digg height = 71
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
