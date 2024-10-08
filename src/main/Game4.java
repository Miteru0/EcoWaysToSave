package main;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import entity.Lumberjack;
import entity.Tree;

public class Game4 implements Game {

    private GamePanel gp;
    private PanelManager pm = PanelManager.INSTANCE;
    private Random random = new Random();
    private List<Lumberjack> lumberjacks = new ArrayList<>();
    private Lumberjack selectedLumberjack;
    private java.awt.Point initialClick;
    private Tree tree;
    private int numberOfLumberJacks = 1;
    public static final String description = "Do later";

    public Game4() {
    }

    @Override
    public void setGamePanel(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void initiateObjects() {
        tree = new Tree(gp, 500, 300, 100, 150);
        numberOfLumberJacks = pm.diffilcuty / 2;
        if (numberOfLumberJacks <= 0) { numberOfLumberJacks = 1;}
        if (numberOfLumberJacks >= 4) { numberOfLumberJacks = 4;}
        for (int i = 0; i < numberOfLumberJacks; i++) {
            int[] pos = getRandomPosition();
            int posX = pos[0];
            int posY = pos[1];
            while (!goodPosition(posX, posY, 64, 64)) {
                posX = pos[0];
                posY = pos[1];
            }
            lumberjacks.add(new Lumberjack(gp, posX, posY, 64, 64, tree));
        }
    }

    public boolean goodPosition(int x, int y, int width, int height) {
        
        for (Lumberjack lumberjack : lumberjacks) {
            if (lumberjack.isInsideObject(x, y, 64, 64)) {
                return false;
            }
        }
        return true;
    }

    public int[] getRandomPosition() {
        int randomX = random.nextInt(1000);
        int randomY;
        if (randomX > 300 && randomX < 700) {
            randomY = random.nextInt(200) + 600;
        }
        else {
            randomY = random.nextInt(600) + 100;
        }
        return new int[] {
            randomX,
            randomY
        };
    }


    @Override
    public void handleTouch(MouseEvent e) {
        for (Lumberjack lumberjack : lumberjacks) {
            if (lumberjack.isInsideObject(e.getX(), e.getY())) {
                selectedLumberjack = lumberjack;
                lumberjack.dragging = true;
                initialClick = e.getPoint();
                break;
            }
        }
    }

    @Override
    public void handleTouchDragging(MouseEvent e) {
        if (selectedLumberjack != null) {
            selectedLumberjack.dragging(e.getX(), e.getY(), initialClick.x, initialClick.y);
            initialClick = e.getPoint();
        }  
    }

    @Override
    public void handleTouchRelease(MouseEvent e) {
        if (selectedLumberjack != null) {
            selectedLumberjack.dragging = false;
            selectedLumberjack = null;
        }
    }


    @Override
    public void update() {
        for (Lumberjack lumberjack : lumberjacks) {
            lumberjack.update();
            if (lumberjack.intersects(tree) && !lumberjack.dragging) {
                lumberjack = null;
                gp.lose();
            }
        }
    }


    @Override
    public void paintComponent(Graphics2D g2) {
        tree.draw(g2);
        for (Lumberjack lumberjack : lumberjacks) {
            lumberjack.draw(g2);
        }
    }
    
}
