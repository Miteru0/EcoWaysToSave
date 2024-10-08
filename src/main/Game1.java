package main;

import entity.Glass;
import entity.GlassTrashBin;
import entity.Plastic;
import entity.PlasticTrashBin;
import entity.Trash;
import entity.TrashBin;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Game1 implements Game{
    private List<Trash> trashlList = new ArrayList<>();
    private List<TrashBin> binList = new ArrayList<>();
    private int trashCount = 2;
    private int target;

    private Trash selectedTrash = null;
    private java.awt.Point initialClick;
    private GamePanel gp;
    public static final String description = "Sort garbage into the appropriate bins (Drag&Drop garbage into bins)";

    public Game1() {
        target = trashCount;
    }

    @Override
    public void setGamePanel(GamePanel gp) {
        this.gp = gp;
    }

    public void initiateObjects() {
        trashlList.add(new Plastic(gp, 100, 450));
        trashlList.add(new Glass(gp, 200, 450));
        binList.add(new GlassTrashBin(gp, 250, 125));
        binList.add(new PlasticTrashBin(gp, 500, 125));
    } 
    @Override
    public void handleTouch(MouseEvent e) {
        for (Trash trash : trashlList) {
            if (trash.isInsideObject(e.getX(), e.getY())) {
                selectedTrash = trash;
                initialClick = e.getPoint();
                break;
            }
        }
        
    }
    @Override
    public void handleTouchRelease(MouseEvent e) {
        if (selectedTrash != null) {
            for (TrashBin trashBin : binList) {
                if (trashBin.intersects(selectedTrash)) {
                    selectedTrash.DestroyObject();
                    if (selectedTrash.type == trashBin.type) {
                        System.out.println("Goodone");
                    }
                    else {
                        System.out.println("Wrong");
                        gp.failed++;
                    }
                    selectedTrash.dragging = false;
                    trashlList.remove(selectedTrash);
                    selectedTrash = null;
                    trashBin.trashRecieved();
                    target--;
                    break;
                }
            }
            
        }
        if (selectedTrash != null) {
            selectedTrash.dragging = false;
            selectedTrash = null;
        }
    }

    @Override
    public void handleTouchDragging(MouseEvent e) {
        if (selectedTrash != null) {
            selectedTrash.dragging(e.getX(), e.getY(), initialClick.x, initialClick.y);
            initialClick = e.getPoint();
        }  
    }

    @Override
    public void update() {
        if (target == 0) {
            if (gp.failed == trashCount + 1) {
                gp.lose();
            }
            else {
                gp.win = 10;
            }
            target = -1;
        }
        for(TrashBin trashbin : binList) {
            trashbin.update();
        }  
    }

    @Override
    public void paintComponent(Graphics2D g2) {
        for(TrashBin trashbin : binList) {
            trashbin.draw(g2);
        }
        for(Trash trash : trashlList) {
            trash.draw(g2);
        }
    }

}
