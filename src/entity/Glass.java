package entity;

import main.GamePanel;

public class Glass extends Trash {

    public Glass(GamePanel gp, int x, int y) {
        super(gp, x, y, 65, 150);
        getImage("src/sprites/trash/glassBottlePixelFramed.png");
    }

    @Override
    protected void setDefaultValues() {
        type = "Glass";
    }
}
