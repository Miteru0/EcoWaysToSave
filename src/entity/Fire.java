package entity;

import java.awt.image.BufferedImage;
import main.GamePanel;
import main.PanelManager;

public class Fire extends Entity {

    public String type;
    public boolean isOn = true;
    public BufferedImage[] idleAnimation;
    private int animationFrames = 10;
    private int animation = 0;
    private int animationReverseSpeed = 5;
    private int startWidth;
    private int startHeight;
    PanelManager pm = PanelManager.INSTANCE;

    public Fire(GamePanel gp, int x, int y, int width, int height) {
        super(gp ,x, y, width, height);
        startWidth = width;
        startHeight = height;
        getImage("src/sprites/fire/fire0.png");
        String[] animationPaths = new String[animationFrames];
        for (int i = 0; i < animationPaths.length; i++) {
            animationPaths[i] = "src/sprites/fire/fire" + i + ".png";
        }
        idleAnimation = getAnimation(animationPaths);
    }

    @Override
    public boolean isInsideObject(int x, int y) {
        return (x >= this.x && x <= this.x + startWidth &&
            y >= this.y && y <= this.y + startHeight);
    }

    @Override
    public void update() {
        if (animation == (animationFrames - 1) * animationReverseSpeed) {animation = 0;} else {animation++;}
        spriteImage = idleAnimation[animation / animationReverseSpeed];
        width += pm.diffilcuty * 2.5;
        height += pm.diffilcuty *2.5;
        x -= pm.diffilcuty * 2.5 / 2;
        y -= pm.diffilcuty * 2.5 / 2;
    }
    
}
