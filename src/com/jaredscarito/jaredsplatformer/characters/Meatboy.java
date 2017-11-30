package com.jaredscarito.jaredsplatformer.characters;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 11/29/2017.
 */
public class Meatboy implements Character {
    private int[] pointsX = null;
    private int[] pointsY = null;
    private int[] armPointsX = null;
    private int[] armPointsY = null;
    private int[] allPoints = null;
    private boolean actionLocked = false;
    private int speed = 0;
    private boolean hidden = false;
    private boolean isMoveable = false;
    private BufferedImage canvas;
    private Color[] cantCollide;

    public Meatboy(int startX, int startY, Graphics g, BufferedImage canvas, int gravitySpeed, boolean isMoveable, Color... cantCollide) {
        this.isMoveable = isMoveable;
        this.canvas = canvas;
        this.speed = gravitySpeed;
        this.cantCollide = cantCollide;
        //Draw his feet
        g.setColor(Color.RED);
        g.drawRect(startX, startY, 8, 8);
        g.fillRect(startX, startY, 8, 8);
        int rightFootStart = startX + 16;
        g.drawRect(rightFootStart, startY, 8, 8);
        g.fillRect(rightFootStart, startY, 8, 8);
        //TODO add the points to arrays


        //Body
        int bodyStartX = startX;
        int bodyStartY = startY - 22;
        g.drawRect(bodyStartX, bodyStartY, 24, 24);
        g.fillRect(bodyStartX, bodyStartY, 24, 24);
        //TODO add the points to arrays


        //Eyes
        int eyesStartX = startX + 3;
        int eyesStartY = startY - 16;
        //Left
        g.setColor(Color.BLACK);
        g.drawOval(eyesStartX, eyesStartY, 5, 5);
        g.fillOval(eyesStartX, eyesStartY, 5, 5);
        //Right
        g.drawOval(eyesStartX + 13, eyesStartY, 5, 5);
        g.fillOval(eyesStartX + 13, eyesStartY, 5, 5);
        //TODO add the points to arrays


        //Arms
        int armsStartX = startX - 5;
        int armsStartY = startY - 13;
        g.setColor(Color.RED);
        //Left
        g.drawRect(armsStartX, armsStartY, 5, 8);
        g.fillRect(armsStartX, armsStartY, 5, 8);
        //Right
        g.drawRect(armsStartX + 28, armsStartY, 5, 8);
        g.fillRect(armsStartX + 28, armsStartY, 5, 8);
    }

    @Override
    public boolean isMoveable() {
        return this.isMoveable;
    }

    @Override
    public int[] getAllPoints() {
        return this.allPoints;
    }

    @Override
    public boolean collides(Shape shape) {
        return false;
    }

    @Override
    public boolean collides(Shape shape, int pixels) {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        //
    }

    @Override
    public void show() {
        this.hidden = false;
    }

    @Override
    public void hide() {
        this.hidden = true;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override
    public int[] getPointsX() {
        return this.pointsX;
    }

    @Override
    public int[] getPointsY() {
        return this.pointsY;
    }

    @Override
    public boolean isActionLocked() {
        return false;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public void setActionLocked(boolean actionLocked) {
        this.actionLocked = actionLocked;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void jump() {
        //
    }

    @Override
    public void moveRight() {
        //
    }

    @Override
    public void moveLeft() {
        //
    }
}
