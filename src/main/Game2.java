package main;

import entity.LightSwitch;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game2 implements Game{
    private List<LightSwitch> lightSwitches = new ArrayList<>();
    private int target = 4;
    private GamePanel gp;
    private FilterPanel filterPanel;
    private PanelManager pm = PanelManager.INSTANCE;
    private Random random = new Random();
    private int numberOfLightSwitches = 4;
    public static final String description = "Turn off the light when you don't need it, so you save energy (Press the light switches to turn off the light)";

    public Game2() {
        filterPanel = pm.getFilter();
    }

    @Override
    public void setGamePanel(GamePanel gp) {
        this.gp = gp;
    }

    public void initiateObjects() {
        for (int i = 0; i < numberOfLightSwitches; i++) {
            int posX = getRandomPositionX();
            int posY = getRandomPositionY();
            while (!goodPosition(posX, posY)) {
                posX = getRandomPositionX();
                posY = getRandomPositionY();
            }
            lightSwitches.add(new LightSwitch(gp, posX, posY, 64, 64));
        }
    } 

    public boolean goodPosition(int x, int y) {
        
        for (LightSwitch lSwitch : lightSwitches) {
            if (lSwitch.isInsideObject(x, y)) {
                return false;
            }
        }
        return true;
    }

    public int getRandomPositionX() {
        return random.nextInt(1000);
    }

    public int getRandomPositionY() {
        return random.nextInt(600) + 100;
    }

    @Override
    public void handleTouch(MouseEvent e) {
        for (LightSwitch lSwitch : lightSwitches) {
            if (lSwitch.isInsideObject(e.getX(), e.getY())) {
                lSwitch.isOn = !lSwitch.isOn;
                if (!lSwitch.isOn) {
                    filterPanel.dark += 200 / numberOfLightSwitches;
                    target--;
                }
                else {
                    filterPanel.dark -= 200 / numberOfLightSwitches;
                    target++;
                }
                System.out.println("You touched the switch");
                break;
            }
        }
        
    }
    @Override
    public void handleTouchRelease(MouseEvent e) {
               
    }

    @Override
    public void handleTouchDragging(MouseEvent e) {
    }

    @Override
    public void update() {
        if (target == 0) {
            gp.win = 10;
            target = -1;
        }
    }

    @Override
    public void paintComponent(Graphics2D g2) {
        for (LightSwitch lSwitch : lightSwitches) {
            lSwitch.draw(g2);
        }
    }
}
