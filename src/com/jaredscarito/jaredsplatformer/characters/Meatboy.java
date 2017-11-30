package com.jaredscarito.jaredsplatformer.characters;

import com.jaredscarito.jaredsplatformer.objects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 11/29/2017.
 */
public class Meatboy implements Character {
    private int[] pointsX = null;
    private int[] pointsY = null;
    //Arms right
    private int[] armPointsRightX = null;
    private int[] armPointsRightY = null;
    //Arms left
    private int[] armPointsLeftX = null;
    private int[] armPointsLeftY = null;
    //Legs Y loc
    private int legsY = 0;
    private boolean actionLocked = false;
    private int speed = 0;
    private boolean hidden = false;
    private boolean isMoveable = false;
    private BufferedImage canvas;
    private Color[] cantCollide;

    //TODO FOR REVAMP
    private HashMap<HashMap<Integer, Integer>, Color> irrelevantPoints;
    private HashMap<Integer, Integer> leftArm;
    private HashMap<Integer, Integer> rightArm;

    public Meatboy(int startX, int startY, Graphics g, BufferedImage canvas, int speed, boolean isMoveable, Color... cantCollide) {
        this.isMoveable = isMoveable;
        this.canvas = canvas;
        this.speed = speed;
        this.cantCollide = cantCollide;


        //Draw his feet
        g.setColor(Color.RED);
        g.drawRect(startX, startY, 8, 8);
        g.fillRect(startX, startY, 8, 8);
        int rightFootStart = startX + 16;
        g.drawRect(rightFootStart, startY, 8, 8);
        g.fillRect(rightFootStart, startY, 8, 8);
        this.legsY = startY + 8;
        //Add the points to array
        ArrayList<Integer> pointsX = new ArrayList<>();
        ArrayList<Integer> pointsY = new ArrayList<>();
        for(int y=startY; y<(startY + 8); y++) {
            //Left foot points
            for(int xLeft=startX; xLeft<(startX + 8); xLeft++) {
                if(canvas.getRGB(xLeft, y) == Color.RED.getRGB()) {
                    pointsX.add(xLeft);
                    pointsY.add(y);
                }
            }
            //Right foot points
            for(int xRight=rightFootStart; xRight<(rightFootStart + 8); xRight++) {
                if(canvas.getRGB(xRight, y) == Color.RED.getRGB()) {
                    pointsX.add(xRight);
                    pointsY.add(y);
                }
            }
        }


        //Body
        int bodyStartX = startX;
        int bodyStartY = startY - 22;
        g.drawRect(bodyStartX, bodyStartY, 24, 24);
        g.fillRect(bodyStartX, bodyStartY, 24, 24);
        //Add the points to array
        for(int x=bodyStartX; x<(bodyStartX + 24); x++) {
            for(int y=bodyStartY; y<(bodyStartY + 24); y++) {
                pointsX.add(x);
                pointsY.add(y);
            }
        }


        //Eyes
        int eyesStartX = startX + 3;
        int eyesStartY = startY - 18;
        //Left
        g.setColor(Color.BLACK);
        g.drawRect(eyesStartX, eyesStartY, 5, 5);
        g.fillRect(eyesStartX, eyesStartY, 5, 5);
        //Right
        g.drawRect(eyesStartX + 13, eyesStartY, 5, 5);
        g.fillRect(eyesStartX + 13, eyesStartY, 5, 5);
        //Should be already counted by being within the body square? ^


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
        //add the points to arrays, armPointsLeftX, armPointsLeftY, armPointsRightX, armPointsRightY
        HashMap<Integer, Integer> leftPoints = new HashMap<>();
        HashMap<Integer, Integer> rightPoints = new HashMap<>();
        //Left
        for(int xLeft=armsStartX; xLeft<(armsStartX + 5); xLeft++) {
            for(int yLeft=armsStartY; yLeft<(armsStartY + 8); yLeft++) {
                leftPoints.put(xLeft, yLeft);
            }
        }
        //Right
        for(int xRight=(armsStartX + 28); xRight<(armsStartX + 5); xRight++) {
            for(int yRight=armsStartY; yRight<(armsStartY + 8); yRight++) {
                rightPoints.put(xRight, yRight);
            }
        }


        //Mouth
        g.setColor(Color.BLACK);
        int topMouthStartX = startX + 8;
        int topMouthStartY = startY - 8;
        g.drawRect(topMouthStartX, topMouthStartY, 9, 2);
        g.setColor(Color.WHITE);
        g.fillRect(topMouthStartX, topMouthStartY, 9, 2);
        g.setColor(Color.BLACK);
        g.drawRect(topMouthStartX + 1, topMouthStartY + 3, 7, 2);
        g.setColor(Color.WHITE);
        g.fillRect(topMouthStartX + 1, topMouthStartY + 3, 7, 2);
        //Should be already counted by being within the body square? ^


        //Setup the arrays here
        this.pointsX = new int[pointsX.size()];
        this.pointsY = new int[pointsY.size()];
        for(int i=0; i<pointsX.size(); i++) {
            int x = pointsX.get(i);
            int y = pointsY.get(i);
            this.pointsX[i] = x;
            this.pointsY[i] = y;
        }

        //Arms arrays
        //Left
        this.armPointsLeftX = new int[leftPoints.size()];
        this.armPointsLeftY = new int[leftPoints.size()];
        int index = 0;
        for(int x : leftPoints.keySet()) {
            int y = leftPoints.get(x);
            this.armPointsLeftX[index] = x;
            this.armPointsLeftY[index] = y;
            index++;
        }
        //Reset index
        index = 0;
        //Right
        this.armPointsRightX = new int[rightPoints.size()];
        this.armPointsRightY = new int[rightPoints.size()];
        for(int x : rightPoints.keySet()) {
            int y = rightPoints.get(x);
            this.armPointsRightX[index] = x;
            this.armPointsRightY[index] = y;
            index++;
        }
    }

    @Override
    public void startGravity() {}

    @Override
    public boolean isMoveable() {
        return this.isMoveable;
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
    public boolean collides(GameObject obj) {
        return false;
    }

    @Override
    public boolean collides(GameObject obj, int pixels) {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        if(!this.hidden) {
            //Draw it
        }
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
