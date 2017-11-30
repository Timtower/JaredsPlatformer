package com.jaredscarito.jaredsplatformer.characters;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 11/29/2017.
 */
public interface Character {
    int[] pointsX = null;
    int[] pointsY = null;
    int[] allPoints = null;
    int[] armPointsX = null;
    int[] armPointsY = null;
    boolean actionLocked = false;
    int speed = 1;
    boolean hidden = false;
    boolean isMoveable = false;


    int[] getPointsX();


    int[] getPointsY();


    int[] getAllPoints();


    boolean isActionLocked();


    boolean isHidden();

    boolean isMoveable();


    int getSpeed();


    void setActionLocked(boolean actionLocked);


    void setSpeed(int speed);


    void jump();


    void moveRight();


    void moveLeft();

    void show();

    void hide();

    void draw(Graphics g);

    boolean collides(Shape shape);

    boolean collides(Shape shape, int pixels);
}
