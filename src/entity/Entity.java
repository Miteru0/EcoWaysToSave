package entity;

import java.awt.image.BufferedImage;
import java.awt.geom.Rectangle2D;

public class Entity extends Rectangle2D.Double{

    public Entity(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public BufferedImage spriteImage;
    
}
