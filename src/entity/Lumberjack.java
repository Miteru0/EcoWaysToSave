package entity;

import main.GamePanel;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

public class Lumberjack extends Entity {

    private double imageAngleRad = 0;
    private Tree tree;
    private int speed = 2;

    public Lumberjack(GamePanel gp, int x, int y, int width, int height, Tree tree) {
        super(gp, x, y, width, height);
        this.tree = tree;
        getImage("src/sprites/lumberjack/lumberjack.png");
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setRenderingHint(
            RenderingHints.KEY_RENDERING, 
            RenderingHints.VALUE_RENDER_QUALITY);
        int cx = (int)x + (int)width / 2;
        int cy = (int)y + (int)height / 2;
        AffineTransform oldAT = g2.getTransform();
        g2.translate(cx, cy);
        g2.rotate(imageAngleRad);
        g2.translate(-cx, -cy);
        g2.drawImage(spriteImage, (int)x, (int)y, (int)width, (int)height, null);
        g2.setTransform(oldAT);
    }

    @Override
    public void update() {
        if (!dragging) {
            moveTowardsTree();
        }
        double dx = tree.x + tree.width / 2 - this.x;
        double dy = tree.y + tree.height / 2 - this.y;
        imageAngleRad = Math.atan2(dy, dx);
    }

    private void moveTowardsTree() {
        double centerX = this.x + width / 2;
        double centerY = this.y + height / 2;
        double dx = tree.x + tree.width / 2 - centerX;
        double dy = tree.y + tree.height / 2 - centerY;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > speed) {
            // Normalize the direction vector and move sprite
            dx /= distance;
            dy /= distance;
            x += dx * speed;
            y += dy * speed;
        }
    }


}
