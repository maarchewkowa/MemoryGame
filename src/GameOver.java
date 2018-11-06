import javax.swing.*;
import java.awt.*;

public class GameOver extends JDialog{

    public GameOver(Window owner, int time, int points, int board){
        super(owner, "Game Over");

        this.setSize(150, 180);
        Helper.formatWindow(this);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        getContentPane().add(new JLabel("= Time ="));
        JLabel timeLabel = new JLabel(Helper.formatTime(time));
        getContentPane().add(timeLabel);
        getContentPane().add(new JLabel("= Points ="));
        JLabel pointsLabel = new JLabel(String.valueOf(points));
        getContentPane().add(pointsLabel);
        getContentPane().add(new JLabel("= Your name ="));
        JTextField nameText = new JTextField();
        getContentPane().add(nameText);
        JButton okButton = new JButton("OK");
        getContentPane().add(okButton);
        okButton.addActionListener(e -> {
            if (nameText.getText().trim().equals(""))
                return;
            else {
                ScoresManager.saveScore(new Score(nameText.getText(), board, points, time));
                getOwner().dispose();
            }

        });


        setVisible(true);


    }

}