
package Model;

public class ScoreBoard {
    public Player player;

    private int one;

    private int two;

    private int three;

    private int four;

    private int five;

    private int six;

    private int bonus;

    private int threeOfAKind;

    private int fourOfAKind;

    private int fullHouse;

    private int smallStraight;

    private int largeStraight;

    private int yahtzze;

    private int chance;

    public void setOne(int points) {
        this.player.setPoints(points);
        this.one = points;
        if (this.bonus == 0)
            setBonus();
    }

    public void setTwo(int points) {
        this.player.setPoints(points);
        this.two = points;
        if (this.bonus == 0)
            setBonus();
    }

    public void setThree(int points) {
        this.player.setPoints(points);
        this.three = points;
        if (this.bonus == 0)
            setBonus();
    }

    public void setFour(int points) {
        this.player.setPoints(points);
        this.four = points;
        if (this.bonus == 0)
            setBonus();
    }

    public void setFive(int points) {
        this.player.setPoints(points);
        this.five = points;
        if (this.bonus == 0)
            setBonus();
    }

    public void setSix(int points) {
        this.player.setPoints(points);
        this.six = points;
        if (this.bonus == 0)
            setBonus();
    }

    public void setBonus() {
        if ((one + two + three + four + five + six) >= 63) {
            this.player.setPoints(35);
            this.bonus = 35;
        } else {
            this.player.setPoints(0);
            this.bonus = 0;
        }
    }

    public void setThreeOfAKind(int points) {
        this.player.setPoints(points);
        this.threeOfAKind = points;
    }

    public void setFourOfAKind(int points) {
        this.player.setPoints(points);
        this.fourOfAKind = points;
    }

    public void setFullHouse(int points) {
        this.player.setPoints(points);
        this.fullHouse = points;
    }

    public void setSmallStraight(int points) {
        this.player.setPoints(points);
        this.smallStraight = points;
    }

    public void setLargeStraight(int points) {
        this.player.setPoints(points);
        this.largeStraight = points;
    }

    public void setYahtzze(int points) {
        this.player.setPoints(points);
        this.yahtzze = points;
    }

    public void setChance(int points) {
        this.player.setPoints(points);
        this.chance = points;
    }

    public int getOne() {
        return one;
    }

    public int getTwo() {
        return two;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getSix() {
        return six;
    }

    public int getBonus() {
        return bonus;
    }

    public int getThreeOfAKind() {
        return threeOfAKind;
    }

    public int getFourOfAKind() {
        return fourOfAKind;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public int getSmallStright() {
        return smallStraight;
    }

    public int getLargeStright() {
        return largeStraight;
    }

    public int getYahtzze() {
        return yahtzze;
    }

    public int getChance() {
        return chance;
    }
}
