package entity;

import main.GamePanel;

public class LightSwitch extends Entity {
    public LightSwitch(GamePanel gp, int x, int y, int width, int height) {
        super(gp, x, y, width, height);
        getImage("src/sprites/lightSwitch/lightSwitch.png");
    }

    public boolean isOn = true;

}
