import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int playerCoordX[] = new int[GAME_UNITS];
    final int playerCoordY[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int foodEaten;
    int foodCoordX;
    int foodCoordY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    public GamePanel(){
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        createFood();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //draws food
        for(int i=0; i < SCREEN_HEIGHT/UNIT_SIZE; i++){
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        g.setColor(Color.RED);
        g.fillOval(foodCoordX, foodCoordY, UNIT_SIZE, UNIT_SIZE);

        //draws snake
        for (int i=0; i < bodyParts; i++){
            if(i == 0){
                g.setColor(Color.GREEN);
                g.fillRect(playerCoordX[i], playerCoordY[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                g.setColor(Color.BLUE);
                g.fillRect(playerCoordX[i], playerCoordY[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public void createFood(){
        foodCoordX = random.nextInt( ( int )( SCREEN_WIDTH / UNIT_SIZE )) * UNIT_SIZE;
        foodCoordY = random.nextInt( ( int )( SCREEN_HEIGHT / UNIT_SIZE )) * UNIT_SIZE;
    }

    public void move(){

        for(int i = bodyParts; i > 0; i--) {
            playerCoordX[i] = playerCoordX[i - 1];
            playerCoordY[i] = playerCoordY[i - 1];
        }
            switch (direction) {
                case 'U':
                    playerCoordY[0] = playerCoordY[0] - UNIT_SIZE;
                    break;
                case 'D':
                    playerCoordY[0] = playerCoordY[0] + UNIT_SIZE;
                    break;
                case 'L':
                    playerCoordX[0] = playerCoordX[0] - UNIT_SIZE;
                    break;
                case 'R':
                    playerCoordX[0] = playerCoordX[0] + UNIT_SIZE;
                    break;
            }
    }

    public void checkFood(){

    }

    public void checkCollisions(){
        /* There's a bug in the following code below which makes the snake not move at al

        //checks if head collides with body
        for(int i=bodyParts; i>0; i--){
            if (playerCoordX[0] == playerCoordX[i] && playerCoordY[0] == playerCoordY[i]){
                running = false;
            }
        }

        //checks if head touches left border of the screen
        if(playerCoordX[0] < 0){
            running = false;
        }

        //checks if head touches right border of the screen
        if(playerCoordX[0] < SCREEN_WIDTH - UNIT_SIZE){
            running = false;
        }

        //checks if head touches top border of screen
        if(playerCoordY[0] < 0){
            running = false;
        }

        //checks if head touches bottom border of screen
        if(playerCoordY[0] > SCREEN_HEIGHT - UNIT_SIZE){
            running = false;
        }

        if(!running){
            timer.stop();
        }*/

        //TODO: fix the bug which makes the snake not move at all
    }

    public void gameOver(Graphics g){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkFood();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
}
