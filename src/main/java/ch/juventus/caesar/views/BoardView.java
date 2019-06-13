package ch.juventus.caesar.views;

import ch.juventus.caesar.models.player.IPlayer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BoardView {

    private ArrayList<IPlayer> players;
    public BoardView(ArrayList<IPlayer> players) {
        this.players = players;
    }

    public void showResultBoard() {
        System.out.println("****************** Result Board ******************");
        for(IPlayer p : this.players) {
            System.out.println(p.getNickName() + ":\t\t" + p.getHand().getValue());
        }
    }

    public void showWinner(IPlayer currentPlayer) {
        IPlayer winner;
        if(currentPlayer.isPantsDown()) {
            winner = currentPlayer;
        } else {
            winner = players.get(0);
            for(int i = 0; i < players.size(); i++) {
                if(winner.getHand().getValue() < players.get(i).getHand().getValue()) {
                    winner = players.get(i);
                }
            }
        }

        System.out.println("Player " + winner.getNickName() + " won with: " + winner.getHand().getValue() + "!");
    }
}
