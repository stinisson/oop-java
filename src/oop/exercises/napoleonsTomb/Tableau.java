package oop.exercises.napoleonsTomb;

public class Tableau extends Pile {

    protected Tableau(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean put(Card card) {

        if (inRange(card)) {

            if (isEmpty()) {
                card.parentPile = name;
                addCard(card, true);
                return true;
            }
        }
        return false;
    }
}
