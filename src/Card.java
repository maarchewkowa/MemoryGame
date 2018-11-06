import javax.swing.*;
import java.awt.*;

public class Card extends JButton {
    private final Color color;
    private Game game;
    private boolean isLocked;

    public Card(Color color, Game game) {
        super("?");
        this.color = color;
        this.game = game;
        this.isLocked = false;

        addActionListener(e -> {
            if (isLocked == false && game.openCard(this) == true){
                setText("");
                setBackground(color);
                setOpaque(true);
                setBorderPainted(false);
            }
        });


    }

    public void close() {
        this.setBackground(Color.white);
        this.setOpaque(false);
        this.setBorderPainted(true);
        this.setText("?");
    }

    public Color getColor() {
        return color;
    }
    public void lock(){
        this.isLocked = true;
    }
}