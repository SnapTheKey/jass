package ch.juventus.caesar.models.player;

import ch.juventus.caesar.models.hand.Hand;

public interface IPlayer {

    Hand getHand();
    int getPlayerPosition();
    void setStop();
    boolean isStopped();
    boolean isPantsDown();
    String getNickName();
}
