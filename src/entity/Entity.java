package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Entity extends Rectangle2D.Double{

    GamePanel gp;
    public boolean dragging = false;

    public Entity(GamePanel gp, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.gp = gp;
        setDefaultValues();
    }
    public BufferedImage spriteImage;
    
    protected void getImage(String path) {
        try {
            File spriteImageFile = new File(path);
            spriteImage = ImageIO.read(spriteImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected BufferedImage[] getAnimation(String[] paths) {
        BufferedImage[] animation = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                File spriteImageFile = new File(paths[i]);
                animation[i] = ImageIO.read(spriteImageFile);

            } catch (IOException e) {
                System.out.println("Failed download with image: " + paths[i]);
                e.printStackTrace();
                
            }
        }
        return animation;
    }

    public boolean isInsideObject(int x, int y) {
        return (x >= this.x && x <= this.x + width &&
            y >= this.y && y <= this.y + height);
    }

    public boolean isInsideObject(Entity entity) {
        return this.intersects(entity);
    }

    public boolean isInsideObject(int x, int y, int width, int height) {
        if (this.intersects(x, y, width, height)) {
            return true;
        }
        return false;
    }

    protected void setDefaultValues() {
    }

    public void update() {
        
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(spriteImage, (int)x, (int)y, (int)width, (int)height, null);
    }

    public void dragging(int x, int y, int initialClickX, int initialClickY) {
        this.x += x - initialClickX;
        this.y += y - initialClickY;
    }

    public void DestroyObject() {
        
    }

}
