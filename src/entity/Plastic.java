package entity;

import main.GamePanel;

public class Plastic extends Trash {

    public Plastic(GamePanel gp, int x, int y) {
        super(gp, x, y, 65, 150);
        getImage("src/sprites/trash/plasticBottlePixel.png");
    }

    @Override
    protected void setDefaultValues() {
        type = "Plastic";
    }
}