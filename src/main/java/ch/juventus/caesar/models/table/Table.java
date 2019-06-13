package ch.juventus.caesar.models.table;

import ch.juventus.caesar.models.hand.Hand;

public class Table implements ITable {
    private Hand hand = new Hand();

    @Override
    public Hand getHand() {
        return this.hand;
    }
}
