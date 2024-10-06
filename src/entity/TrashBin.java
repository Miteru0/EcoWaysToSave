package entity;

import main.GamePanel;

public class TrashBin extends Entity {

    public String type;
    private boolean playAnimation = false;
    private int animation = 0;

    public TrashBin(GamePanel gp, int x, int y, int width, int height) {
        super(gp, x, y, width, height);
    }

    public void trashRecieved() {
        playAnimation = true;
    }

    @Override
    public void update() {
        if (playAnimation) {
            animation++;
        }
        if( animation == 1) {
            width += 25;
            height += 25;
        }
        else if(animation == 5) {
            width -= 25;
            height -= 25;
            playAnimation = false;
            animation = 0;
        }
    }

    public boolean isInsideObject(Trash trash) {
        return this.intersects(trash);
    }

}
