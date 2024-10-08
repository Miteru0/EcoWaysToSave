package entity;

import java.awt.Graphics2D;
import main.GamePanel;
import main.PanelManager;
import java.awt.BasicStroke;
import java.awt.Color;

public class Timer extends Entity{
    
    PanelManager pm = PanelManager.INSTANCE;
    boolean differentTimer = false;

    public Timer(GamePanel gp) {
        super(gp, 35, 35, 1000, 50);
    }

    public Timer(GamePanel gp, boolean differentTimer) {
        super(gp, 35, 35, 1000, 50);
        this.differentTimer = differentTimer;
    }

    public void update() {
        if (differentTimer) {
            if (width > 0) {
                width -= 2;
            }
            else {
                TimesUp();
                width = -1;
            }
        }
        else {
            if (width > 0) {
                width -= pm.diffilcuty;
            }
            else {
                TimesUp();
                width = -1;
            }
        }
    }

    public void TimesUp() {
        if (differentTimer) {
            System.out.println("Time's up! And it's good!");
            gp.win(true);
        }
        else {
            System.out.println("Time's up!");
            gp.lose();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect((int)x, (int)y, (int)width, (int)height);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(6f));
        g2.drawRect((int)x, (int)y, (int)1000, (int)height);
    }

}
