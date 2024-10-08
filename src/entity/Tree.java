package entity;

import main.GamePanel;

public class Tree extends Entity{

    public Tree(GamePanel gp, int x, int y, int width, int height) {
        super(gp, x, y, width, height);
        getImage("src/sprites/tree/tree.png");
    }

}
