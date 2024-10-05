package entity;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import main.GamePanel;

public class PlasticTrashBin extends TrashBin {
    public PlasticTrashBin(GamePanel gp, int x, int y) {
        super(gp, x, y, 125, 175);
        setDefaultValues();
        getImage();
    }

    public void getImage() {
        try {
            File spriteImageFile = new File("src/sprites/trashBin/plasticBin.png");
            spriteImage = ImageIO.read(spriteImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefaultValues() {
        width = 150;
        height = 175;
        type = "Plastic";
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(spriteImage, (int)x, (int)y, (int)width, (int)height, null);
    }
}
