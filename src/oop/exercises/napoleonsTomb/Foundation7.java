package oop.exercises.napoleonsTomb;

public class Foundation7 extends Pile {

    protected Foundation7(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean put(Card card) {

        System.out.println(card.getCardColor());

        if (inRange(card) && card.getCardValue() == 7) {
            card.parentPile = name;
            addCard(card);
            return true;
        }
        return false;
    }

}
