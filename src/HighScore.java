import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HighScore extends JDialog {
    public HighScore(Frame owner) {
        super(owner, "High Score", true);

        this.setSize(200, 300);
        Helper.formatWindow(this);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        DefaultListModel defaultListModel = new DefaultListModel();
        JList list = new JList(defaultListModel);
        List<Score> scores = ScoresManager.loadScores();
        scores.sort((o1, o2) -> Integer.compare(o2.getPoints(),o1.getPoints()));

        for (int i = 0; i < scores.size(); i++){
            defaultListModel.addElement(scores.get(i));
        }
        getContentPane().add(list);

        setVisible(true);
    }
}