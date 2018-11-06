import javax.swing.*;
import java.awt.*;

public class GameSetUp extends JDialog {
    public GameSetUp(Frame owner) {
        super(owner, "Pick Size", true);

        this.setSize(150, 150);
        Helper.formatWindow(this);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        getContentPane().add(new JLabel("SET SIZE"));

        BoardSizeModel boardSizeModel = new BoardSizeModel();
        JComboBox sizeGame = new JComboBox(boardSizeModel);
        //sizeGame.setSelectedIndex(2);
        getContentPane().add(sizeGame);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            BoardSize boardSize = (BoardSize)boardSizeModel.getSelectedItem();
            Board game = new Board(this, boardSize.getSize());

        });
        getContentPane().add(okButton);

        setVisible(true);

    }
}