package oop.exercises.napoleonsTomb;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NapoleonsTomb extends JFrame implements ActionListener {

    private final JButton newButton;
    private final JButton fixButton;
    private final JButton exitButton;
    private final GameBoard gameBoard;
    private static final int d = 100;
    private static final int windowWidth = 812;
    private static final int windowHeight = 571;
    private static final Dimension buttonDimension = new Dimension(100, 26);
    private static final Color darkGreen = new Color(6, 95, 69, 255);

    public NapoleonsTomb() {
        super("Napoleon's Tomb");

        newButton = new JButton("New game");
        fixButton = new JButton("Fixed order");
        exitButton = new JButton("Exit");

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

        buttonPanel.setBackground(darkGreen);

        setBounds(d, d, windowWidth, windowHeight);
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
        NapoleonsTomb napoleonsTomb = new NapoleonsTomb();
    }
}
