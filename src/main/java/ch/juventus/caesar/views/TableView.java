package ch.juventus.caesar.views;

import ch.juventus.caesar.models.player.IPlayer;
import ch.juventus.caesar.models.table.ITable;

public class TableView {

    ITable table;

    public TableView(ITable table) {
        this.table = table;
    }

    public void showTable() {
        System.out.println("Table cards:");
        HandView handView = new HandView(this.table.getHand());
        handView.showHand();
    }
}
