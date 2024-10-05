package entity;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Glass extends Trash {

    public Glass(GamePanel gp, int x, int y) {
        super(gp, x, y, 100, 200);
        setDefaultValues();
        getImage();
    }

    public void getImage() {
        try {
            File spriteImageFile = new File("src/sprites/trash/glassBottlePixelFramed.png");
                spriteImage = ImageIO.read(spriteImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefaultValues() {
        width = 65;
        height = 150;
        type = "Glass";
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(spriteImage, (int)x, (int)y, (int)width, (int)height, null);
    }
}
