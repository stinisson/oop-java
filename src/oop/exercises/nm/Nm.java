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
        numMatches = gameStart();

        while (true) {
            numMatches = makeMove(isComputer, numMatches);
            isComputer = !isComputer;

            if (numMatches == 1 && !isComputer) {
                System.out.println("\nHuman loses, Computer wins.");
                break;
            } else if (numMatches <= 1 && isComputer){
                System.out.println("\nComputer loses, Human wins.");
                break;
            }
        }
    }

    public int gameStart() {
        System.out.println("\n*** Welcome to Nm! ***");
        if (numMatches < 4) {
            System.out.println(numMatches + " matches, how fun would that be? " +
                    "The game needs to be played with at least 4 matches.");
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

        if (isComputer) {
            drawnMatches = computer.requestMove(numMatches);
            System.out.println("\nComputer removes " + drawnMatches + " matches");

        } else {
            System.out.println("\nYour move. There are " + numMatches + " matches");
            System.out.print("Number of matches to draw: ");
            drawnMatches = human.requestMove(numMatches);
            System.out.println("Human removes " + drawnMatches + " matches");
        }
        numMatches -= drawnMatches;
        System.out.println("Remaining matches: " + numMatches);
        return numMatches;
    }


    public static void main(String[] args) throws IOException {
        Nm nm = new Nm();
        try {
            int numMatches = Integer.parseInt(args[0]);
            nm.run(numMatches);
        } catch (NumberFormatException | IOException ignored) {
            System.out.println("Please specify number of of matches as an integer.");
            System.out.println("Program ends.");
        }
    }

}

