package entity;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LightSwitch extends Entity {
    public LightSwitch(JPanel gp, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setDefaultValues();
        getImage();
    }


    private int width;
    private int height;
    public JPanel gp;
    public String type;
    public boolean isOn = true;

    public void setDefaultValues() {

    }

    public void getImage() {
        try {
            File spriteImageFile = new File("src/sprites/lightSwitch/lightSwitch.png");
            spriteImage = ImageIO.read(spriteImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isInsideObject(int x, int y) {
        return (x >= this.x && x <= this.x + width &&
            y >= this.y && y <= this.y + height);
    }

    public void DestroyObject() {
        
    }

    public void update() {
        
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(spriteImage, (int)x, (int)y, (int)width, (int)height, null);
    }
}
