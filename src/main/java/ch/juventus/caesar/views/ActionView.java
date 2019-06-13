package ch.juventus.caesar.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActionView {

    private BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public boolean askStopOrSkipTheRound() {
        return this.askYesNoQuestion("Do you want to stop/skip [y/n]");
    }

    public boolean askAllCardChange() {
        return this.askYesNoQuestion("Do you want to change all cards [y/n]");
    }

    public int[] askWhichCardsToChange() {
        try {
            System.out.println("Which card do you want to switch [tableCardIndex/playerCardIndex][0-2/0-2]");
            String cardsToSwitchStr = reader.readLine();
            String[] cardsToSwitch = cardsToSwitchStr.split("/");
            int[] index = new int[2];
            index[0] = Integer.parseInt(cardsToSwitch[0]);
            index[1] = Integer.parseInt(cardsToSwitch[0]);
            if(index[0] < 0 || index[0] > 2 || index[1] < 0 || index[1] > 2) {
                System.out.println("Number is out of range. please select your cards between index 0 and 2");
                return askWhichCardsToChange();
            }
            return index;
        } catch (IOException e) {
            System.out.println("couldn't parse the line, please try again");
            return this.askWhichCardsToChange();
        } catch (Exception e) {
            System.out.println("couldn't parse your number, please try again");
            return this.askWhichCardsToChange();
        }
    }

    private boolean askYesNoQuestion(String question) {
        System.out.println(question);
        try {
            String answer = reader.readLine();
            return answer.equals("y");
        } catch (IOException e) {
            System.out.println("couldn't parse the line, please try again");
            return askYesNoQuestion(question);
        }
    }
}
