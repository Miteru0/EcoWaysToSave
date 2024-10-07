package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextArea;

public class DescriptionPanel extends JPanel implements Runnable {
    PanelManager pm = PanelManager.INSTANCE;
    private int FPS = 60;
    Thread gameThread;
    private int timer = 120;
    private int index;


    public DescriptionPanel(String descriptionString, int index) {
        this.setPreferredSize(new Dimension(pm.gameWidth, pm.gameHeight));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);  
        this.index = index; 
        JTextArea text = new JTextArea(descriptionString);
        text.setForeground(Color.BLACK);
        text.setBackground(Color.GRAY);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(text);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

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
    }    
    
    public void update() {
        if (timer > 0) {
            timer--;
        }
        else {
            pm.setScene(index);
            gameThread.stop();
            gameThread = null;
        }
    }

    
}
