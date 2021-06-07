package oop.exercises.tenta.uppgift2;

import java.util.Random;


public class SimpleGameOOP {

    public static void main (String [] arg) {

        Player player1 = new Player("Adam");
        Player player2 = new Player("Bob");

        while (player1.getScore() < 10 && player2.getScore() < 10) {
            player1.makeMove();
            player2.makeMove();
        }
        if (player1.getScore() >= 10 && player2.getScore() >= 10) { // Adam was first to get more than 10.
            System.out.println("It's a tie!");
        } else if (player1.getScore() >= 10) {
            System.out.println(player1.getName() + " wins.");
        }
        else {
            System.out.println(player2.getName() + " wins.");
        }
    }
}


class Dice {

    private static final int numSides = 6;
    private static final Random randomGenerator =  new Random();

    public int roll() {
        return randomGenerator.nextInt(numSides) + 1;
    }
}

class Player {

    private final String name;
    private final Dice dice;
    private int score;

    public Player(String name) {
        this.name = name;
        dice = new Dice();
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void makeMove() {
        int roll = dice.roll();
        System.out.println("Player " + name + " rolls " + roll + ".");
        score += roll;
        System.out.println("Player " + name + "'s score is " + score + ".\n");
    }
}
