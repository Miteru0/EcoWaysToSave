package entity;
import main.GamePanel;

import java.awt.Graphics2D;

public class Trash extends Entity {

    public GamePanel gp;
    public boolean dragging = false;
    public String type;

    public void dragging(int x, int y, int initialClickX, int initialClickY) {
        this.x += x - initialClickX;
        this.y += y - initialClickY;
    }

    public boolean isInsideObject(int x, int y) {
        return (x >= this.x && x <= this.x + width &&
            y >= this.y && y <= this.y + height);
    }

    public Trash(GamePanel gp, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.gp = gp;
        this.x = x;
        this.y = y;
    }

    public void DestroyObject() {
        
    }

    public void update() {
        
    }

    public void draw(Graphics2D g2) {
        g2.draw(null);
    }
}
