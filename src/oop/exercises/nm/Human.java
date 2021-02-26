package oop.exercises.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Human extends Player {

    @Override
    public int requestMove(int numMatches) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int draw = -1;
        while (draw == -1) {
            try {
                draw = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException ignored) {}

            if (!(draw > 0 && draw <= numMatches/2)) {
                System.out.println("Sorry, illegal move.");
                System.out.println("Please choose at least one match and at most " + numMatches/2);
                System.out.println("\nYour move. There are " + numMatches + " matches");
                System.out.print("Number of matches to draw: ");
                draw = -1;
            }
        }
        return draw;
    }
}
