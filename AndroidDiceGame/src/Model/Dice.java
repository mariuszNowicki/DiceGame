
package Model;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    public int spots;

    public boolean active;

    public int tempSpots[] = new int[7];

    public Dice(ArrayList<Dice> diceList) {
        for (int k = 0; k < 7; k++)
            this.tempSpots[k] = 0;

        for (int j = 0; j < diceList.size(); j++) {
            for (int i = 1; i < 7; i++) {
                if (diceList.get(j).spots == i)
                    this.tempSpots[i] += 1;
            }
        }
    }

    public Dice() {

    }

    public Dice createDice() {
        Dice dice = new Dice();
        dice.active = true;
        return dice;
    }

    public ArrayList<Dice> roll(ArrayList<Dice> diceList) {
        for (int i = 0; i < diceList.size(); i++)
            if (diceList.get(i).active == true) {
                Random random = new Random();
                diceList.get(i).spots = random.nextInt(6) + 1;
            }

        for (int i = 0; i < diceList.size(); i++) {
            diceList.get(i).active = false;
        }

        return diceList;
    }

    public int isOne() {
        return this.tempSpots[1];
    }

    public int isTwo() {
        return (this.tempSpots[2] * 2);
    }

    public int isThree() {
        return (this.tempSpots[3] * 3);
    }

    public int isFour() {
        return (this.tempSpots[4] * 4);
    }

    public int isFive() {
        return (this.tempSpots[5] * 5);
    }

    public int isSix() {
        return (this.tempSpots[6] * 6);
    }

    public int isThreeOfAKind() {
        for (int i = 1; i < 7; i++)
            if (this.tempSpots[i] >= 3)
                return (this.tempSpots[i] * i);
        return 0;
    }

    public int isFourOfAKind() {
        for (int i = 1; i < 7; i++)
            if (this.tempSpots[i] >= 4)
                return (this.tempSpots[i] * i);
        return 0;
    }

    public int isFullHouse() {
        for (int i = 1; i < 7; i++)
            if (this.tempSpots[i] == 3)
                for (int j = 1; j < 7; j++)
                    if (this.tempSpots[j] == 2)
                        return 25;
        return 0;
    }

    public int isSmallStraight() {
        if (this.tempSpots[1] >= 1 && this.tempSpots[2] >= 1 && this.tempSpots[3] >= 1
                && this.tempSpots[4] >= 1)
            return 30;
        else if (this.tempSpots[2] >= 1 && this.tempSpots[3] >= 1 && this.tempSpots[4] >= 1
                && this.tempSpots[5] >= 1)
            return 30;
        else if (this.tempSpots[3] >= 1 && this.tempSpots[4] >= 1 && this.tempSpots[5] >= 1
                && this.tempSpots[6] >= 1)
            return 30;
        else
            return 0;
    }

    public int isLargeStraight() {
        if (this.tempSpots[1] == 1 && this.tempSpots[2] == 1 && this.tempSpots[3] == 1
                && this.tempSpots[4] == 1 && this.tempSpots[5] == 1)
            return 40;
        else if (this.tempSpots[2] == 1 && this.tempSpots[3] == 1 && this.tempSpots[4] == 1
                && this.tempSpots[5] == 1 && this.tempSpots[6] == 1)
            return 40;
        else
            return 0;
    }

    public int isYahtzze() {
        for (int i = 1; i < 7; i++)
            if (this.tempSpots[i] == 5)
                return 50;
        return 0;
    }

    public int isChance() {
        int chance = 0;
        for (int i = 1; i < 7; i++) {
            chance += this.tempSpots[i] * i;
        }
        return chance;
    }
}
