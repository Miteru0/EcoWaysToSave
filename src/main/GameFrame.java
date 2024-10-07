package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class GameFrame extends JFrame implements ActionListener {


    public JPanel panel;
    public JPanel filter;
    public DescriptionPanel dPanel;
    PanelManager pm = PanelManager.INSTANCE;

    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Eco Ways to Save");
        this.panel = pm.getPanel(0); // get Panel
        this.filter = pm.getFilter();
        setLayout(new OverlayLayout(getContentPane()));
        this.add(filter);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setScene(int index) {
        this.remove(panel);
        this.remove(filter);
        this.remove(dPanel);
        this.panel = pm.getPanel(index);
        if (index >= 1) {
            ((GamePanel) panel).startGameThread();
        }
        setLayout(new OverlayLayout(getContentPane()));
        this.add(filter);
        ((FilterPanel)filter).applyFilter();
        this.add(panel);
        this.pack();
    }

    public void setSceneDescription(int index) {
        this.remove(panel);
        this.remove(filter);
        this.dPanel = pm.getPanelDescription(index);
        dPanel.startGameThread();
        this.add(dPanel);
        this.pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
    }



}
