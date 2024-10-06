package entity;

import main.GamePanel;

public class GlassTrashBin extends TrashBin {

    public GlassTrashBin(GamePanel gp, int x, int y) {
        super(gp, x, y, 150, 175);
        getImage("src/sprites/trashBin/glassBin.png");
    }

    @Override
    protected void setDefaultValues() {
        type = "Glass";
    }
}
