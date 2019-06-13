package ch.juventus.caesar.models.deck;

public class DeckFactory {
    private static DeckFactory ourInstance = new DeckFactory();

    public static DeckFactory getInstance() {
        return ourInstance;
    }

    private DeckFactory() {
    }

    public IDeck createDeck() {
        return new Deck();
    }
}
