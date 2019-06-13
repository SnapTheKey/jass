package ch.juventus.caesar.models.player;

import ch.juventus.caesar.models.hand.Hand;

public class Player implements IPlayer {

    private static final int PANTS_DOWN_VALUE = 310;

    private Hand hand = new Hand();
    private String nickName;
    private int playerPosition;
    private boolean isStopped = false;

    public Player(String nickName, int playerPosition) {
        this.nickName = nickName;
        this.playerPosition = playerPosition;
    }

    @Override
    public Hand getHand() {
        return this.hand;
    }

    @Override
    public int getPlayerPosition() {
        return this.playerPosition;
    }

    @Override
    public void setStop() {
        this.isStopped = true;
    }

    @Override
    public boolean isStopped() {
        return this.isStopped;
    }

    @Override
    public boolean isPantsDown() {
        return this.hand.getValue() == PANTS_DOWN_VALUE;
    }

    @Override
    public String getNickName() {
        return this.nickName;
    }
}
