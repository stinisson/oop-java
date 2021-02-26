package oop.exercises.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Nm {
    private boolean isComputer = true;
    private final Computer computer;
    private final Human human;

    Nm() {
        computer = new Computer();
        human = new Human();
    }

    public int gameStart() throws IOException {
        System.out.println("Welcome to Nm! How many matches should we start the game with? ");
        System.out.print("Number of matches: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numMatches = Integer.parseInt(reader.readLine());
        System.out.println("Great, we'll use " + numMatches + " matches.");

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

    public void run() throws IOException {
        int numMatches = gameStart();
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

    public static void main( String[] arg) throws IOException {
        Nm nm = new Nm();
        nm.run();
    }

}

