import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        GamePanel panel = new GamePanel();
        add(panel);
    }
}
