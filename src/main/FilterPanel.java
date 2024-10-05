package main;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;

public class FilterPanel extends JPanel{

    PanelManager pm = PanelManager.INSTANCE;
    public int dark = 0;
    
    public FilterPanel() {
        this.setDoubleBuffered(true);
        applyFilter();
    }

    public void applyFilter() {
        repaint();
    }


    public void paintComponent(Graphics2D g2) {
        g2.setColor(new Color(0, 0, 0, dark)); // RGBA: 150 for transparency
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.dispose();
    }
}
