package ch.juventus.caesar.models.hand;

public class HandFactory {
    private static HandFactory ourInstance = new HandFactory();

    public static HandFactory getInstance() {
        return ourInstance;
    }

    private HandFactory() {
    }

    public IHand createHand() {
        return new Hand();
    }
}
