import java.io.Serializable;

public class Score implements Serializable{

    private String name;
    private int boardSize;
    private int points;
    private int gameTime;

    public Score(String name, int boardSize, int points, int gameTime) {
        this.name = name;
        this.boardSize = boardSize;
        this.points = points;
        this.gameTime = gameTime;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + " (" + boardSize + ") - " + Helper.formatTime(gameTime) + ": " + points + "pkt";
    }

}
