import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        setTitle("Snake");
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
