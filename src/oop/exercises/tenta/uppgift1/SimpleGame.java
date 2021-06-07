package oop.exercises.tenta.uppgift1;

import java.util.Random;

public class SimpleGame {

    static Random randomGenerator =  new Random();

    public static int roll() {
        return randomGenerator.nextInt(6) + 1;
    }

    public static void main (String [] arg) {
        String player1 = "Adam";
        String player2 = "Bob";

        int adam = 0;
        int bob = 0;

        while (adam < 10 && bob < 10) {
            int adamRoll = roll();
            System.out.println("Player Adam rolls "+adamRoll);
            adam = adam+adamRoll;
            System.out.println("Player Adam's score is "+adam);

            int bobRoll = roll();
            System.out.println("Player Bob rolls "+bobRoll);
            bob = bob+bobRoll;
            System.out.println("Player Bob's score is "+bob);
        }
        if (10 <= adam) { // Adam was first to get more than 10.
            System.out.println("Adam wins");
        }
        else {
            System.out.println("Bob wins");
        }


    }
}