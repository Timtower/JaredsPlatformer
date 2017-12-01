package com.jaredscarito.jaredsplatformer.characters;

import com.jaredscarito.jaredsplatformer.objects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 11/29/2017.
 */
public interface GameCharacter {
    int[] pointsX = null;
    int[] pointsY = null;
    int[] armPointsLeftX = null;
    int[] armPointsLeftY = null;
    int[] armPointsRightX = null;
    int[] armPointsRightY = null;
    int legsY = 0;
    boolean actionLocked = false;
    int speed = 1;
    boolean hidden = false;
    boolean isMoveable = false;


    void startGravity();


    int[] getPointsX();


    int[] getPointsY();

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

    boolean collides(GameObject obj);

    boolean collides(GameObject obj, int pixels);
}
