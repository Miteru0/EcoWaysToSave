package entity;

import java.awt.Graphics2D;
import main.GamePanel;
import main.PanelManager;
import java.awt.BasicStroke;
import java.awt.Color;

public class Timer extends Entity{
    PanelManager pm = PanelManager.INSTANCE;
    GamePanel panel;

    public Timer(GamePanel panel) {
        super(35, 35, 1000, 50);
        this.panel = panel;
        setDefaultValues();
    }

    public void setDefaultValues() {
        width = 1000;
        height = 50;
        x = 35;
        y = 35;
    }

    public void update() {
        if (width > 0) {
            width -= pm.diffilcuty;
        }
        else {
            TimesUp();
            width = -1;
        }
    }

    public void TimesUp() {
        System.out.println("Time's up!");
        panel.lose();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect((int)x, (int)y, (int)width, (int)height);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(6f));
        g2.drawRect((int)x, (int)y, (int)1000, (int)height);
    }

}
