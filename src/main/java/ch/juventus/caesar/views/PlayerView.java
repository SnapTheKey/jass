package ch.juventus.caesar.views;

import ch.juventus.caesar.models.player.IPlayer;

public class PlayerView {

    IPlayer player;

    public PlayerView(IPlayer player) {
        this.player = player;
    }

    public void showPlayer() {
        System.out.println("Player: " + this.player.getNickName());
    }
}
