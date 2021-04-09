package oop.exercises.napoleonsTomb;

public class Parking extends Pile {
    protected Parking(int x, int y,String name) {
        super(x, y, name);
    }

    public boolean put(Card card) {
        System.out.println(card.getCardValue());


        if (inRange(card) && card.getCardValue() == 6) {
            card.parentPile = name;
            addCard(card);
            return true;
        }
        return false;
    }
}
