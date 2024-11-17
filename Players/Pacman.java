package Players;

import Objects.Block;
import Objects.GeneralElement;
import Objects.Speed;

import javax.swing.*;
import java.awt.*;

public class Pacman extends GeneralElement implements Speed, Movement {
    private int speed = 5;
    int score;
    private int locationX;
    private int locationY;
    private int nextUpLoc;
    private int nextDownLoc;
    private int nextRightLoc;
    private int nextLeftLoc;

    public int getScore() {
        return score;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getNextUpLoc() {
        return nextUpLoc;
    }

    public int getNextDownLoc() {
        return nextDownLoc;
    }

    public int getNextRightLoc() {
        return nextRightLoc;
    }

    public int getNextLeftLoc() {
        return nextLeftLoc;
    }

    public Pacman(int x, int y) {
        setPoint(x, y);
        image = new ImageIcon("src/Pictures/PacmanLeftOpen.jpg");
        score = 0;
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public void setPoint(int x, int y) {
        point.x = x;
        point.y = y;
        locationY = point.y / width;
        locationX = point.x / width;
        nextUpLoc = locationY  - 1;
        nextDownLoc = locationY  + 1;
        nextRightLoc = locationX  + 1;
        nextLeftLoc =  locationX  - 1;

    }

    @Override
    public boolean isEaten() {
        return true;
    }

    @Override
    public Image getImage() {
        return image.getImage();
    }

    @Override
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOnFullY(){
        return getY() % 25 == 0;
    }

    public boolean isOnFullX(){
        return getX() % 25 == 0;
    }

    public boolean canMoveUp(GeneralElement[][] myMap){
            return isOnFullX() && !(myMap[nextUpLoc][locationX] instanceof Block);
    }

    @Override
    public boolean canMoveDown(GeneralElement[][] myMap) {
       return isOnFullX() && !(myMap[nextDownLoc][locationX] instanceof Block);
    }

    @Override
    public boolean canMoveRight(GeneralElement[][] myMap) {
       return isOnFullY() && !(myMap[locationY][nextRightLoc] instanceof Block);
    }

    @Override
    public boolean canMoveLeft(GeneralElement[][] myMap) {
         return isOnFullY() && !(myMap[locationY][nextLeftLoc] instanceof Block);
    }

    @Override
    public int getX() {
        return point.x;
    }

    @Override
    public int getY() {
        return point.y;
    }
}
