package oop.exercises.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Nm {
    public static void main( String[] arg) throws IOException {

        System.out.println("Let's play Nim! How many sticks should we start the game with it? ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Number of sticks: ");
        int numMatches = Integer.parseInt(reader.readLine());
        System.out.println("Great, we'll use " + numMatches + " matches.");


        System.out.println("\nPlayer 1: Computer");
        System.out.println("Player 2: Human");
        System.out.println("Remaining matches: " + numMatches);





        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        System.out.println("You entered " + number);

    }
}

