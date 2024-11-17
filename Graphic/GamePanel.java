package Graphic;

import Maps.MapLevel1;
import Objects.Coin;
import Objects.Empty;
import Objects.GeneralElement;
import Players.Pacman;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int size = 25;
    int speed = 25;
    Pacman pacman = new Pacman(13 * size, 21 * size);
    MapLevel1 mapLevel1 = new MapLevel1();
    GeneralElement[][] myMap = mapLevel1.ElementMap();
    KeyControl keyControl = new KeyControl();
    Thread thread;

    public GamePanel() {
        this.addKeyListener(keyControl);
        this.setFocusable(true);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < myMap.length; i++) {
            for (int j = 0; j < myMap[i].length; j++) {
                g.drawImage(myMap[i][j].getImage(), myMap[i][j].getPoint().x, myMap[i][j].getPoint().y, size, size, this);
            }
        }
        g.drawImage(pacman.getImage(), pacman.getPoint().x, pacman.getPoint().y, size, size, this);
    }

    public void movePacman() {
        int tempX;
        int tempY;
        if (keyControl.up) {
            pacman.setImage(new ImageIcon("src/Pictures/PacmanUpOpen.jpg"));
            if (pacman.canMoveUp(myMap)) {
                tempY = pacman.getNextUpLoc();
                tempX = pacman.getLocationX();
                pacman.setPoint(pacman.getX(), pacman.getY() - speed);
                if (myMap[tempY][tempX] instanceof Coin){
                    myMap[tempY][tempX] = new Empty(tempX, tempY);
                }


            }
        } else if (keyControl.down) {
            pacman.setImage(new ImageIcon("src/Pictures/PacmanDownOpen.jpg"));
            if (pacman.canMoveDown(myMap)) {
                pacman.setPoint(pacman.getX(), pacman.getY() + speed);
            }
        } else if (keyControl.right) {
            pacman.setImage(new ImageIcon("src/Pictures/PacmanRightOpen.jpg"));
            if (pacman.canMoveRight(myMap)) {
                pacman.setPoint(pacman.getX() + speed, pacman.getY());
            }
        } else if (keyControl.left) {
            pacman.setImage(new ImageIcon("src/Pictures/PacmanLeftOpen.jpg"));
            if (pacman.canMoveLeft(myMap)){
                pacman.setPoint(pacman.getX() - speed, pacman.getY());
            }
        }

    }

@Override
public void run() {
    while (true) {
        movePacman();
        repaint();
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
}
