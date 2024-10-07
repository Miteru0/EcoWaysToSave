package main;

import java.awt.Graphics2D;
import java.awt.event.*;

public interface Game {

    public void setGamePanel(GamePanel gp);

    public void initiateObjects();

    public void handleTouch(MouseEvent e);

    public void handleTouchDragging(MouseEvent e);

    public void handleTouchRelease(MouseEvent e);

    public void update();

    public void paintComponent(Graphics2D g2);

}
