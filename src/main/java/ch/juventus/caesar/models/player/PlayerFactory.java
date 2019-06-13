package ch.juventus.caesar.models.player;

public class PlayerFactory {
    private static PlayerFactory ourInstance = new PlayerFactory();

    public static PlayerFactory getInstance() {
        return ourInstance;
    }

    private PlayerFactory() {

    }

    public IPlayer createPlayer(String nickName, int order) {
        return new Player(nickName, order);
    }
}
