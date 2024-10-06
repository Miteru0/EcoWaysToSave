package entity;
import main.GamePanel;

public class Trash extends Entity {

    public boolean dragging = false;
    public String type;

    public Trash(GamePanel gp, int x, int y, int width, int height) {
        super(gp, x, y, width, height);
    }

    public void dragging(int x, int y, int initialClickX, int initialClickY) {
        this.x += x - initialClickX;
        this.y += y - initialClickY;
    }


}
