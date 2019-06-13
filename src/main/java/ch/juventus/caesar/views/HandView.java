package ch.juventus.caesar.views;

import ch.juventus.caesar.models.card.Card;
import ch.juventus.caesar.models.card.CardColor;
import ch.juventus.caesar.models.hand.IHand;

import java.util.ArrayList;
import java.util.Arrays;

public class HandView {

    private IHand hand;

    public HandView(IHand hand) {
        this.hand = hand;
    }

    public void showHand() {
        ArrayList<Card> cards = this.hand.getCards();
        System.out.println("*__________________________________________*");
        System.out.println("|***********    ***********    *********** |");
        System.out.println("|*         *    *         *    *         * |");
        System.out.println("|*   -0-   *    *   -1-   *    *   -2-   * |");
        System.out.println("|*         *    *         *    *         * |");
        System.out.println("|* " + this.fillDataViewWithSpace(cards.get(0).getColor().name()) + " *    * "
                                 + this.fillDataViewWithSpace(cards.get(1).getColor().name()) + " *    * "
                                 + this.fillDataViewWithSpace(cards.get(2).getColor().name()) + " * |");
        System.out.println("|* " + this.fillDataViewWithSpace(cards.get(0).getValue().name()) + " *    * "
                                 + this.fillDataViewWithSpace(cards.get(1).getValue().name()) + " *    * "
                                 + this.fillDataViewWithSpace(cards.get(2).getValue().name()) + " * |");
        System.out.println("|*         *    *         *    *         * |");
        System.out.println("|***********    ***********    *********** |");
        System.out.println("*==========================================*");
    }

    private String fillDataViewWithSpace(String data) {
        char[] dataArr = data.toCharArray();
        char[] array = new char[7];
        Arrays.fill(array, ' ');
        for(int i = 0; i < data.length(); i++) {
            array[i] = dataArr[i];
        }
        return new String(array);
    }
}
