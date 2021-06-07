package oop.exercises.tenta.uppgift3;

import java.util.Random;

public class SimpleGameBob {

    public static void main (String [] arg) {

        Player player1 = new Player();
        Player player2 = new Player();

        player1.playerInit("Adam", false);
        player2.playerInit("Bob", true);

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

abstract class CommonDice {

    abstract int roll();
}

class Dice extends CommonDice {

    private static final int numSides = 6;
    private static final Random randomGenerator =  new Random();

    public int roll() {
        return randomGenerator.nextInt(numSides) + 1;
    }
}

class CleverDice extends CommonDice {

    private static final Dice dice = new Dice();

    public int roll() {

        while (true) {
            int roll = dice.roll();
            if (roll >= 5) { return roll; }
        }
    }
}

class Player {

    private String name;
    private CommonDice dice;
    private int score;

    public Player() {
        score = 0;
    }

    public void playerInit(String name, boolean useCleverDice) {
        this.name = name;
        if (useCleverDice) {
            dice = new CleverDice();
        } else {
            dice = new Dice();
        }
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
