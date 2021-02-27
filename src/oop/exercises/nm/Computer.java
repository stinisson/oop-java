package oop.exercises.nm;

import java.util.Random;

class Computer extends Player {
    final Random rand;

    Computer() {
        rand = new Random();
    }

    @Override
    public int requestMove(int startRange, int endRange, int numMatches) {
        return startRange + rand.nextInt(endRange - startRange + 1);
    }
}
