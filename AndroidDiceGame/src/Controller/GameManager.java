
package Controller;

import Model.Dice;
import Model.Player;
import Model.ScoreBoard;

import java.util.ArrayList;

public class GameManager {
    private static int numberOfDices = 5;

    public int gameTurn;

    public int gameTurnFinal;

    public int whoPlay;

    public Dice dice;

    public ArrayList<Dice> diceList = new ArrayList<Dice>();

    public ArrayList<ScoreBoard> scoreBoardList = new ArrayList<ScoreBoard>();

    public void getPlayers(String name, int wins, int id) {
        ScoreBoard playerScore = new ScoreBoard();
        playerScore.player = new Player().createPlayer(name, wins, id);
        scoreBoardList.add(playerScore);
    }

    public void getDice() {
        for (int i = 0; i < numberOfDices; i++) {
            diceList.add(new Dice().createDice());
        }
    }

    public void playGameFirst() {
        gameTurnFinal = 0;
        whoPlay = 1;
        new Dice().roll(diceList);
        gameTurn = 1;
    }

    public void playGameRoll() {
        if (gameTurn < 3) {
            new Dice().roll(diceList);
            gameTurn++;
        }
    }

    public void playGamePointAdd() {
        if (whoPlay == scoreBoardList.size()) {
            whoPlay = 1;
            gameTurnFinal++;
        } else
            whoPlay++;
        if (gameTurnFinal != 13) {
            for (int i = 0; i < diceList.size(); i++)
                diceList.get(i).active = true;
            new Dice().roll(diceList);
            gameTurn = 1;
        } else
            gameTurnFinal = 99;
    }

    public void show() {
        for (int i = 0; i < scoreBoardList.size(); i++) {
            ScoreBoard playerScore = scoreBoardList.get(i);
            System.out.println("Gracz " + (i + 1) + " " + playerScore.player.getName()
                    + " zdobył " + playerScore.player.getPoints() + "pkt");
        }
    }

}
