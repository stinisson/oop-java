package oop.exercises.nm;

import java.util.Random;

public class Computer extends Player {

    @Override
    public int requestMove(int numMatches) {
        Random rand = new Random();
        int draw = rand.nextInt(numMatches/2);
        draw += 1;
        return draw;
    }
}
