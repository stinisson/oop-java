package oop.exercises.napoleonsTomb;

public class Foundation6 extends Pile {
    protected Foundation6(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean put(Card card) {

        System.out.println(card.getCardColor());

        if (inRange(card)) {
            card.parentPile = name;
            addCard(card);
            return true;
        }
        return false;
    }
}
