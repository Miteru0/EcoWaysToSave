package main;
import javax.swing.JPanel;

import entity.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;


public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;

    //FPS
    int FPS = 60;


    private Timer timer;
    public int win = 0;
    public int failed = 1;
    PanelManager pm = PanelManager.INSTANCE;
    Game game;
    FilterPanel filterPanel = (FilterPanel)pm.getFilter();

    public GamePanel(Game game) {
        failed = 1;
        this.game = game;
        game.setGamePanel(this);
        // Add mouse listener to handle touch input
        addMouseListeners();
        initiateObjects();
        timer = new Timer(this);
        this.setPreferredSize(new Dimension(pm.gameWidth, pm.gameHeight));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
    }

    public GamePanel(Game game, boolean differentTimer) {
        failed = 1;
        this.game = game;
        game.setGamePanel(this);
        // Add mouse listener to handle touch input
        addMouseListeners();
        initiateObjects();
        if (differentTimer) {
            timer = new Timer(this, true);
        }
        this.setPreferredSize(new Dimension(pm.gameWidth, pm.gameHeight));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
    }

    private void addMouseListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleTouch(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                handleTouchRelease(e);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                handleTouchDragging(e);
            }
        });
    }

    public void initiateObjects() {
        game.initiateObjects();
    }


    private void handleTouch(MouseEvent e) {
        game.handleTouch(e);
    }

    private void handleTouchDragging(MouseEvent e) {
        game.handleTouchDragging(e);
    }

    private void handleTouchRelease(MouseEvent e) {
        game.handleTouchRelease(e);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /* @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        update();
        repaint();

        try {
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime / 1000000;
            if (remainingTime < 0) {
                remainingTime = 0;
            }
            Thread.sleep((long)remainingTime);    
            nextDrawTime += drawInterval;

        } catch (Exception e) {
        }
    }                  */                                  // Default Time loop

    @Override  
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }                                                       //DeltaTime run



    public void update() {
        game.update();
        if (win>=2) {
            win--;
        }
        if(win == 2) {
            win();
        }
        else {
            timer.update();
        }
    }

    public void win() {
        System.out.println("Congrats");
        filterPanel.dark = 0;
        pm.score += (timer.width + (pm.diffilcuty * 50))/failed;
        if (pm.score > pm.maxScore) {
            pm.maxScore = pm.score;
        }
        pm.diffilcuty += pm.diffilcutyChanger;
        pm.setScene(0);
        destroyScene();
    }

    public void win(boolean differentTimer) {
        if (differentTimer) {
            System.out.println("Congrats");
            filterPanel.dark = 0;
            pm.score += 500 + (pm.diffilcuty * 50)/failed;
            if (pm.score > pm.maxScore) {
                pm.maxScore = pm.score;
            }
            pm.diffilcuty += pm.diffilcutyChanger;
            pm.setScene(0);
            destroyScene();
        }
    }

    public void lose() {
        filterPanel.dark = 0;
        if (pm.score > pm.maxScore) {
            pm.maxScore = pm.score;
        }
        pm.score = 0;
        pm.diffilcuty = 1;
        pm.setScene(0);
        destroyScene();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        game.paintComponent(g2);
        timer.draw(g2);
        filterPanel.paintComponent(g2);
        g2.dispose();
    }

    public void destroyScene() {
        game = null;
        gameThread.stop();
        gameThread = null;
    }

}

