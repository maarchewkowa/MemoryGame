import javax.swing.*;
import java.awt.*;

public class Helper {
    public static String formatTime(int seconds){
        return String.format("%d : %02d", seconds/60, seconds%60);
    }
    public static void formatWindow(Window window){
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        int frameWidth = window.getSize().width;
        int frameHeight = window.getSize().height;

        window.setLocation((screenWidth-frameWidth)/2, (screenHeight-frameHeight)/2);
    }
}