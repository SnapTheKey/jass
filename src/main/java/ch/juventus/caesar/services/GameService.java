package ch.juventus.caesar.services;


import ch.juventus.caesar.models.card.Card;
import ch.juventus.caesar.models.deck.DeckFactory;
import ch.juventus.caesar.models.deck.IDeck;
import ch.juventus.caesar.models.hand.Hand;
import ch.juventus.caesar.models.hand.IHand;
import ch.juventus.caesar.models.player.IPlayer;
import ch.juventus.caesar.models.player.Player;
import ch.juventus.caesar.models.player.PlayerFactory;
import ch.juventus.caesar.models.table.ITable;
import ch.juventus.caesar.models.table.TableFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GameService {

    private ArrayList<IPlayer> players = new ArrayList<IPlayer>();
    private IDeck deck;
    private ITable table;
    private BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public GameService() {
        this.initGame();
    }

    private void initGame() {
        System.out.println("Welcome players, please add all Players who wants to play (min: 2, max: 8)");

        try {
            this.createPlayer();
            this.startGame();
        } catch (IOException e) {
            //TODO handle exception
        }
    }

    private boolean isCreateNewPlayer() throws IOException {
        System.out.println("do you want to create a player? [y/n]:");
        String answer = reader.readLine();
        return answer.equals("y");
    }

    private void createPlayer() throws IOException {
        System.out.println("Nick name: ");
        String nickName = reader.readLine();
        players.add(PlayerFactory.getInstance().createPlayer(nickName, players.size()));
        if(this.players.size() < 2 || this.isCreateNewPlayer()) {
            this.createPlayer();
        }
    }

    private void distributeCards() {

        LinkedList<IHand> hands = new LinkedList<IHand>();
        for(int i = 0; i < players.size(); i++) {
            hands.add(players.get(i).getHand());
        }
        hands.add(this.table.getHand());
        Card card = this.deck.getCard();
        int nextIndex = 0;
        while (card != null && hands.getLast().getCards().size() != 3) {
            hands.get(nextIndex).setCard(card);
            card = this.deck.getCard();
            if(hands.get(nextIndex).equals(hands.getLast())) {
                nextIndex = 0;
            } else {
                nextIndex++;
            }
        }
    }

    private void startGame() {
        this.deck = DeckFactory.getInstance().createDeck();
        this.table = TableFactory.getInstance().createTable();
        this.distributeCards();
        new GamePlayManager(this.table, this.players);
    }

}
