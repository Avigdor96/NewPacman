package Graphic;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        GamePanel gamePanel = new GamePanel();
        this.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setBackground(Color.BLACK);
        top.setPreferredSize(new Dimension(0,50));
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.BLACK);
        bottom.setPreferredSize(new Dimension(0,50));
        this.add(top, BorderLayout.NORTH);
        this.add(gamePanel, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);
        gamePanel.setVisible(true);
        this.setSize(715, 920);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);




    }
}
