package oop.exercises.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Human extends Player {

    @Override
    public int requestMove(int startRange, int endRange, int numMatches) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int draw = -1;
        while (draw == -1) {
            try {
                draw = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException ignored) {}

            if (!(draw >= startRange && draw <= endRange)) {
                System.out.println("Sorry, illegal move.");
                System.out.println("Please choose at least " + startRange + " match and at most " + endRange);
                System.out.println("\nYour move. There are " + numMatches + " matches");
                System.out.print("Number of matches to draw: ");
                draw = -1;
            }
        }
        return draw;
    }
}
