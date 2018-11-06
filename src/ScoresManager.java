import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ScoresManager {
    public static void saveScore(Score score) {

        try {
            List<Score> scores = loadScores();
            scores.add(score);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Scores.txt"));
            out.writeObject(scores);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static List<Score> loadScores() {
        if (!Files.exists(Paths.get("Scores.txt"))){
            return new ArrayList<Score>();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Scores.txt"));
            List<Score> result = (List<Score>) in.readObject();
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}