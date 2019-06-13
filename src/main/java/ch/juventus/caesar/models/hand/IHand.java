package ch.juventus.caesar.models.hand;

import ch.juventus.caesar.models.card.Card;

import java.util.ArrayList;

public interface IHand {

    void setCard(Card card);
    ArrayList<Card> getCards();
    int getValue();

    Card switchCard(Card cardToSwitch, Card switchedCard);
    ArrayList<Card> switchCards(ArrayList<Card> cards);
}
