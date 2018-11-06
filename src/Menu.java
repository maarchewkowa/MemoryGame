import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    public Menu (){
        super("Memory s17428");

        this.setSize(150, 180);
        Helper.formatWindow(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(new JLabel("Memory game"));

        JButton newGame = new JButton("New Board");
        newGame.addActionListener(e -> {
           new GameSetUp(this);
        });
        getContentPane().add(newGame);
        JButton highScore = new JButton("High Score");
        highScore.addActionListener(e ->{
            new HighScore(this);
        });
        getContentPane().add(highScore);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        getContentPane().add(exitButton);

        setVisible(true);
    }

}

