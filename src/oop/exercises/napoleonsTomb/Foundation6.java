package oop.exercises.napoleonsTomb;

public class Foundation6 extends Pile {

    protected Foundation6(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean put(Card card) {

        System.out.println(card.getCardColor());

        if (inRange(card)) {

            if (isEmpty() && card.getCardValue() == 6) {
                card.parentPile = name;
                addCard(card);
                return true;
            }

            if (!isEmpty() && card.getCardValue() == getTopCard().getCardValue() - 1) {
                card.parentPile = name;
                addCard(card);
                return true;
            }

            if (!isEmpty() && getTopCard().getCardValue() == 1 && card.getCardValue() == 6) {
                card.parentPile = name;
                addCard(card);
                return true;
            }

        }
        return false;
    }
}
