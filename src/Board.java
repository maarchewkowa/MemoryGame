import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JDialog {
    private JLabel timeLabel;
    private Game game;
    private int boardSize;

    public Board(Window owner, int boardSize) {
        super(owner, "Memory");
        this.boardSize = boardSize;

        this.setSize(boardSize*100,boardSize*100);
        Helper.formatWindow(this);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        timeLabel = new JLabel("0:00");
        this.game = new Game(this, (boardSize*boardSize)/2);
        getContentPane().add(timeLabel);
        JPanel memoryPanel = new JPanel(new GridLayout(boardSize, boardSize));

        ArrayList<Color> colors = new ArrayList<>();


        for (int i = 0; i < (boardSize*boardSize)/2; i++){
           Color color = new Color((int) (Math.random()*255),(int) (Math.random()*255), (int) (Math.random()*255));
           colors.add(color);
           colors.add(color);
        }
        for (int i = 0; i < (boardSize * boardSize); i++){
            int colorNumber = (int) (Math.random()*colors.size());
            Card cardButton = new Card(colors.get(colorNumber), game);
            colors.remove(colorNumber);
            memoryPanel.add(cardButton);
        }

        getContentPane().add(memoryPanel);

        setVisible(true);

    }

    public void setTimeValue(int seconds){
        timeLabel.setText(Helper.formatTime(seconds));
    }
    public int getBoardSize() {
        return boardSize;
    }
}