package oop.exercises.nm;

import java.io.IOException;


public class Nm {
    private boolean isComputer = true;
    private int numMatches;
    private final Computer computer;
    private final Human human;

    Nm() {
        computer = new Computer();
        human = new Human();
    }

    public void run(int numMatches) throws IOException {
        this.numMatches = numMatches;
        numMatches = gameIntro();

        while (true) {
            numMatches = makeMove(isComputer, numMatches);
            isComputer = !isComputer;

            if (numMatches == 1 && !isComputer) {
                System.out.println("\nHuman loses, Computer wins.");
                break;
            } else if (numMatches == 1 && isComputer){
                System.out.println("\nComputer loses, Human wins.");
                break;
            }
        }
    }

    public int gameIntro() {
        System.out.println("\n*** Welcome to Nm! ***");
        if (numMatches < 4 | numMatches > 1000) {
            System.out.println(numMatches + " matches, how fun would that be?");
            System.out.println("The game needs to be played with at least 4 matches but moderation is a virtue," +
                    " so not too many, ok?");
            numMatches = 7;
        }
        System.out.println("This game will be played with " + numMatches + " matches.");
        System.out.println("\nPlayer 1: Computer");
        System.out.println("Player 2: Human");
        System.out.println("Remaining matches: " + numMatches);
        return numMatches;
    }

    public int makeMove(boolean isComputer, int numMatches) {
        int drawnMatches;
        int minDraw = 1;
        int maxDraw = numMatches/2;

        if (isComputer) {
            drawnMatches = computer.requestMove(minDraw, maxDraw, numMatches);
            System.out.println("\nComputer removes " + drawnMatches + " matches");

        } else {
            System.out.println("\nYour move. There are " + numMatches + " matches");
            System.out.print("Number of matches to draw: ");
            drawnMatches = human.requestMove(minDraw, maxDraw, numMatches);
            System.out.println("\nHuman removes " + drawnMatches + " matches");
        }
        numMatches -= drawnMatches;
        System.out.println("Remaining matches: " + numMatches);
        return numMatches;
    }


    public static void main(String[] args) {
        Nm nm = new Nm();
        try {
            int numMatches = Integer.parseInt(args[0]);
            nm.run(numMatches);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | IOException ignored) {
            System.out.println("Number of matches to start the game with must be given as an integer.");
            System.out.println("Program ends.");
        }
    }

}

