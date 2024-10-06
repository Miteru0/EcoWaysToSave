package entity;

import main.GamePanel;

public class PlasticTrashBin extends TrashBin {

    public PlasticTrashBin(GamePanel gp, int x, int y) {
        super(gp, x, y, 150, 175);
        getImage("src/sprites/trashBin/plasticBin.png");
    }

    @Override
    protected void setDefaultValues() {
        type = "Plastic";
    }

}
