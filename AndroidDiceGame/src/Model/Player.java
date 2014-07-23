
package Model;


public class Player {
    private int ID;

    private String name;

    private int points;

    private int wins;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins += wins;
    }

    public Player() {

    }

    public Player createPlayer(String name, int wins, int id) {
        Player player = new Player();
        player.setName(name);
        player.setWins(wins);
        player.setID(id);
        return player;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
