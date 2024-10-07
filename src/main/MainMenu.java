package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.util.Random;

import java.awt.Color;

public class MainMenu extends JPanel {

    Random random = new Random();

    public MainMenu() {
        PanelManager pm = PanelManager.INSTANCE;
        this.setPreferredSize(new Dimension(pm.gameWidth, pm.gameHeight));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
        JButton button = new JButton("Start Game");
        JTextArea text = new JTextArea("Score: " + pm.score);
        JTextArea maxScoreText = new JTextArea("Score: " + pm.maxScore);
        this.add(button);
        this.add(text);
        this.add(maxScoreText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomGameIndex = random.nextInt(pm.numberOfGames) + 1;
                pm.setSceneDescription(randomGameIndex);
            }
        });

    }


}
