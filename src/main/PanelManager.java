package main;

import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;

public enum PanelManager {
    INSTANCE;
    List<JPanel> panels = new ArrayList<>();
    FilterPanel filter = new FilterPanel();
    GameFrame window;
    int timer;
    public final int diffilcutyChanger = 1;
    public int diffilcuty = 1;
    public int score;
    public int maxScore = -1;
    public final int gameWidth = 1080;
    public final int gameHeight = 800;
    public final int numberOfGames = 2;


    public void start() {
        filter.setOpaque(false);
        addPanel(new MainMenu());
        addPanel(new GamePanel(new Game1()));
        window = new GameFrame();
    }

    
    public void addPanel(JPanel panel) {
        panels.add(panel);
    }

    public void addPanel(JPanel panel, int index) {
        panel.add(panel, index);
    }

    public void removePanel(int index) {
        panels.remove(index);
    }
    
    public void removePanel(JPanel panel) {
        panel.remove(panel);
    }

    public void setScene(int index) {
        window.setScene(index);
    }

    public JPanel getPanel(int index) {
        switch (index) {
            case 0:
                return new MainMenu();
            case 1:
                return new GamePanel(new Game1());
            case 2:
                return new GamePanel(new Game2());
            default:
                return null;
        }
    }

    public FilterPanel getFilter() {
        return filter;
    }
    
}
