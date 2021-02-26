package oop.exercises.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import oop.exercises.nm.Computer;
import oop.exercises.nm.Human;



public class Nm {

    public int gameStart() throws IOException {
        System.out.println("Welcome to Nm! How many matches should we start the game with? ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Number of matches: ");
        int numMatches = Integer.parseInt(reader.readLine());
        System.out.println("Great, we'll use " + numMatches + " matches.");
        return numMatches;
    }
    public static void main( String[] arg) throws IOException {

        Nm game = new Nm();
        int numMatches = game.gameStart();

        System.out.println("\nPlayer 1: Computer");
        System.out.println("Player 2: Human");
        System.out.println("Remaining matches: " + numMatches);

        while (true) {

            // CPU MOVE
            Random rand = new Random();
            int n = rand.nextInt(numMatches/2 );
            n += 1;
            System.out.println("\nComputer removes " + n + " matches");
            numMatches -= n;
            System.out.println("Remaining matches: " + numMatches);
            if (numMatches <= 1) {
                System.out.println("\nHuman loses, Computer wins");
                break;
            }

            // Human move
            System.out.println("\nYour move. There are " + numMatches + " matches");
            System.out.print("Number of matches to draw: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int userChoice = -1;
            while (userChoice == -1) {
                try {
                    userChoice = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException ignored) {

                }

                if (!(userChoice > 0 &&  userChoice <= numMatches/2)) {
                    System.out.println("Sorry, illegal move.");
                    System.out.println("Please choose at least one match and at most " + numMatches/2);
                    System.out.println("\nYour move. There are " + numMatches + " matches");
                    System.out.print("Number of matches to draw: ");
                    userChoice = -1;
                }
            }

            System.out.println("Human removes " + userChoice + " matches");
            numMatches -= userChoice;
            System.out.println("Remaining matches: " + numMatches);
            if (numMatches <= 1) {
                System.out.println("\nComputer loses, Human wins");
                break;
            }
        }

    }
}

