package oop.exercises.napoleonsTomb;

public class Foundation6 extends Pile {

    protected Foundation6(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean put(Card card) {

        if (inRange(card)) {

            if (isEmpty() && card.getCardValue() == 6) {
                card.setParentPileName(name);
                addCard(card, true);
                return true;
            }

            if (!isEmpty() && card.getCardValue() == getTopCard().getCardValue() - 1) {
                card.setParentPileName(name);
                addCard(card, true);
                return true;
            }

            if (!isEmpty() && getTopCard().getCardValue() == 1 && card.getCardValue() == 6) {
                card.setParentPileName(name);
                addCard(card, true);
                return true;
            }

        }
        return false;
    }
}
