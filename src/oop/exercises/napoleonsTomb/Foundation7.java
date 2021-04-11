package oop.exercises.napoleonsTomb;

public class Foundation7 extends Pile {

    protected Foundation7(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean put(Card card) {
        if (inRange(card)) {

            if (isEmpty() && card.getCardValue() == 7) {
                card.setParentPileName(name);
                addCard(card, true);
                return true;
            }

            if (!isEmpty() && card.getCardValue() == getTopCard().getCardValue() + 1) {
                card.setParentPileName(name);
                addCard(card, true);
                return true;
            }

            if (!isEmpty() && getTopCard().getCardValue() == 13) {
                return false;
            }

        }
        return false;
    }
}
