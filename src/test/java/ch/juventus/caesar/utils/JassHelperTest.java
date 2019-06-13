package ch.juventus.caesar.utils;

import static org.junit.Assert.assertEquals;

import ch.juventus.caesar.models.card.Card;
import org.junit.Test;

import java.util.ArrayList;

public class JassHelperTest
{
    @Test
    public void shouldCalculateThreeSameColorCards() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.ACORN_KING);
        cards.add(Card.ACORN_NINE);
        cards.add(Card.ACORN_ASS);
        assertEquals(JassHelper.calculateValues(cards), 300);
    }

    @Test
    public void shouldCalculateTwoSameColorCards() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.ACORN_KING);
        cards.add(Card.ACORN_NINE);
        cards.add(Card.BELL_ASS);
        assertEquals(JassHelper.calculateValues(cards), 190);
    }

    @Test
    public void shouldCalculateHighestCardsValue() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.ACORN_KING);
        cards.add(Card.SHIELD_NINE);
        cards.add(Card.BELL_ASS);
        assertEquals(JassHelper.calculateValues(cards), 110);
    }

    @Test
    public void shouldCalculateThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.ACORN_KING);
        cards.add(Card.SHIELD_KING);
        cards.add(Card.BELL_KING);
        assertEquals(JassHelper.calculateValues(cards), 305);
    }
}
