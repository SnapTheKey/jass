package ch.juventus.caesar.services;

import ch.juventus.caesar.models.card.Card;
import ch.juventus.caesar.models.player.IPlayer;
import ch.juventus.caesar.models.player.Player;
import ch.juventus.caesar.models.table.ITable;
import ch.juventus.caesar.views.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GamePlayManager {

    private IPlayer currentPlayer;
    private ArrayList<IPlayer> players;
    private ITable table;
    private BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    //TODO should be done by state machine
    public GamePlayManager(ITable table, ArrayList<IPlayer> players) {
        this.table = table;
        this.players = players;
        this.currentPlayer = this.players.get(0);
        try {
            this.start();
        } catch (IOException e) {
            //TODO handle nicely the exception
        }

    }

    private boolean isGameDone() {
        if(this.currentPlayer.isPantsDown()) {
            return true;
        }
        boolean allStopped = true;
        for(int i = 0; i < players.size(); i++) {
            if(!players.get(i).isStopped()) {
                allStopped = false;
                //TODO remove this hack!!!
                break;
            }
        }
        return allStopped;
    }

    private void start() throws IOException {
        int currentPlayerIndex = 0;
        boolean playerStopped = false;
        int lastIndex = this.players.size();
        while(!this.isGameDone()) {
            this.currentPlayer = this.players.get(currentPlayerIndex);

            TableView tableView = new TableView(this.table);
            tableView.showTable();

            PlayerView playerView = new PlayerView(this.currentPlayer);
            playerView.showPlayer();

            HandView handView = new HandView(this.currentPlayer.getHand());
            handView.showHand();

            ActionView actionView = new ActionView();

            if(actionView.askStopOrSkipTheRound()) {
                playerStopped = true;
            } else {
                this.switchCards(actionView);
            }

            if(playerStopped) {
                this.currentPlayer.setStop();
            }
            if(currentPlayerIndex == lastIndex - 1) {
                currentPlayerIndex = 0;
            } else {
                currentPlayerIndex++;
            }
        }

        BoardView boardView = new BoardView(this.players);
        boardView.showWinner(this.currentPlayer);
        boardView.showResultBoard();


    }

    private void switchCards(ActionView actionView) throws IOException {
        if(actionView.askAllCardChange()) {
            ArrayList<Card> playersCard = new ArrayList<>(this.currentPlayer.getHand().getCards());
            ArrayList<Card> tablesCard = new ArrayList<>(this.table.getHand().getCards());
            this.currentPlayer.getHand().switchCards(tablesCard);
            this.table.getHand().switchCards(playersCard);
            return;
        }
        int[] indexesToChange = actionView.askWhichCardsToChange();
        Card tablesCard = new ArrayList<>(this.table.getHand().getCards()).get(indexesToChange[0]);
        Card playersCard = new ArrayList<>(this.currentPlayer.getHand().getCards()).get(indexesToChange[1]);
        this.currentPlayer.getHand().switchCard(playersCard, tablesCard);
        this.table.getHand().switchCard(tablesCard, playersCard);
    }
}
