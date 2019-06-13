package ch.juventus.caesar.models.deck;

import ch.juventus.caesar.models.card.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck implements IDeck {

    ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(Card.values()));

    public Deck() {
        Collections.shuffle(cards);
    }

    @Override
    public Card getCard() {
        return cards.size() > 0 ? cards.remove(0) : null;
    }
}
