package entity;

import main.GamePanel;

public class AluminiumTrashBin extends TrashBin {


    public AluminiumTrashBin(GamePanel gp, int x, int y) {
        super(gp, x, y, 150, 175);
        getImage("src/sprites/trashBin/aluminiumBin.png");
    }

    @Override
    protected void setDefaultValues() {
        type = "Aluminium";
    }
}
