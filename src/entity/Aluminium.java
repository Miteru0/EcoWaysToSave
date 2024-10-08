package entity;

import main.GamePanel;

public class Aluminium extends Trash{

    public Aluminium(GamePanel gp, int x, int y) {
        super(gp, x, y, 65, 125);
        getImage("src/sprites/trash/aluminiumCan.png");
    }

    @Override
    protected void setDefaultValues() {
        type = "Aluminium";
    }

}
