package oop.exercises.napoleonsTomb;

public class Parking extends Pile {
    protected Parking(int x, int y,String name) {
        super(x, y, name);
    }

    public boolean put(Card card) {

        if (inRange(card) && card.getCardValue() == 6 && isEmpty()) {
            card.setParentPileName(name);
            addCard(card, true);
            return true;
        }
        return false;
    }
}
