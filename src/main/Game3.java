package main;

import entity.Fire;
import java.awt.Graphics2D;
import java.awt.event.*;

public class Game3 implements Game{
    private int target = 1;
    private GamePanel gp;
    private PanelManager pm = PanelManager.INSTANCE;
    private Fire fire;
    public static final String description = "Put out the fire after resting in the forest (click on the fire repeatedly to extinguish it";


    public Game3() {
    }

    @Override
    public void setGamePanel(GamePanel gp) {
        this.gp = gp;
    }

    public void initiateObjects() {
        fire = new Fire(gp, 350, 275, 400, 400);
    } 


   

    @Override
    public void update() {
        if (fire.width > 0) {
            fire.update();
        }
        else if (fire.width < 0){
            fire.width = 0;
            fire.height = 0;
            target = 0;
        }
        if (target == 0) {
            gp.win = 10;
            target = -1;
        }
        
    }

    @Override
    public void paintComponent(Graphics2D g2) {
        fire.draw(g2);
    }

    @Override
    public void handleTouch(MouseEvent e) {
        if (fire.isInsideObject(e.getX(), e.getY())) {
            fire.width -= pm.diffilcuty * 50;
            fire.height -= pm.diffilcuty * 50;
            fire.x += pm.diffilcuty * 50 / 2;
            fire.y += pm.diffilcuty * 50 / 2;
        }
    }

    @Override
    public void handleTouchDragging(MouseEvent e) {
    }

    @Override
    public void handleTouchRelease(MouseEvent e) {

    }

}
