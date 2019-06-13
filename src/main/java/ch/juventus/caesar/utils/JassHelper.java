package ch.juventus.caesar.utils;

import ch.juventus.caesar.models.card.Card;
import ch.juventus.caesar.models.card.CardColor;
import ch.juventus.caesar.models.card.CardValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class JassHelper {

    private static final int THREE_OF_A_KIND_SET_SIZE = 1;
    private static final int THREE_OF_A_KIND_VALUE = 305;

    public static int calculateValues(ArrayList<Card> cards) {
        if (JassHelper.isThreeOfAKind(cards)) {
            return THREE_OF_A_KIND_VALUE;
        }
        HashMap<CardColor, Integer> cardValues = new HashMap<>();
        for(int i = 0; i < cards.size(); i++) {
            Card currentCard = cards.get(i);
            int cardValue = currentCard.getValue().getValue();
            if(cardValues.containsKey(currentCard.getColor())) {
                cardValue = cardValues.get(currentCard.getColor()) + cardValue;
            }
            cardValues.put(currentCard.getColor(), cardValue);
        }
        return Collections.max(cardValues.values());
    }

    private static boolean isThreeOfAKind(ArrayList<Card> cards) {
        HashSet<CardValue> cardSet = new HashSet<>();
        cards.forEach(card -> cardSet.add(card.getValue()));
        return cardSet.size() == THREE_OF_A_KIND_SET_SIZE;
    }

}
