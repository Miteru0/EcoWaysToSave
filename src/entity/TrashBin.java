package entity;

import main.GamePanel;
import java.awt.Graphics2D;

public class TrashBin extends Entity {
    public GamePanel gp;
    public String type;
    private boolean playAnimation = false;
    private int animation = 0;

    public TrashBin(GamePanel gp, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gp = gp;
    }

    public boolean isInsideObject(int x, int y) {
        return (x >= this.x && x <= this.x + width &&
            y >= this.y && y <= this.y + height);
    }


    public void trashRecieved() {
        playAnimation = true;
    }

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

    public void draw(Graphics2D g2) {
        g2.draw(null);
    }

}
