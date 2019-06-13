package ch.juventus.caesar.models.hand;

import ch.juventus.caesar.models.card.Card;
import ch.juventus.caesar.utils.JassHelper;

import java.util.ArrayList;

public class Hand implements IHand {

    ArrayList<Card> cards = new ArrayList<>();

    @Override
    public void setCard(Card card) {
        if (cards.size() > 3) {
            //TODO throw exception
            return;
        }
        cards.add(card);
    }

    @Override
    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public int getValue() {
        return JassHelper.calculateValues(this.cards);
    }

    @Override
    public Card switchCard(Card cardToSwitch, Card switchedCard) {
        int cardIndex = this.cards.indexOf(cardToSwitch);
        ArrayList<Card> oldCards = new ArrayList<>(this.cards);
        this.cards.set(cardIndex, switchedCard);
        return oldCards.get(cardIndex);
    }

    @Override
    public ArrayList<Card> switchCards(ArrayList<Card> cards) {
        ArrayList<Card> oldCards = new ArrayList<>(this.cards);
        this.cards = cards;
        return oldCards;
    }
}
