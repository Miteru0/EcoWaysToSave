package entity;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import main.GamePanel;

public class Plastic extends Trash {

    public boolean dragging = false;

    public Plastic(GamePanel gp, int x, int y) {
        super(gp, x, y, 150, 200);
        setDefaultValues();
        getImage();
    }

    public void dragging(int x, int y, int initialClickX, int initialClickY) {
        this.x += x - initialClickX;
        this.y += y - initialClickY;
    }

    public boolean isInsideObject(int x, int y) {
        return (x >= this.x && x <= this.x + width &&
            y >= this.y && y <= this.y + height);
    }

    public void getImage() {
        try {
            File spriteImageFile = new File("src/sprites/trash/plasticBottlePixel.png");
                spriteImage = ImageIO.read(spriteImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefaultValues() {
        width = 75;
        height = 150;
        type = "Plastic";
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(spriteImage, (int)x, (int)y, (int)width, (int)height, null);
    }
}