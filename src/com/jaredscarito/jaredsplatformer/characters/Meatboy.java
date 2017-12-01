package com.jaredscarito.jaredsplatformer.characters;

import com.jaredscarito.jaredsplatformer.objects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by user on 11/29/2017.
 */
public class Meatboy extends CharacterCollideable implements GameCharacter {
    //Legs Y loc
    private int legsY = 0;
    private boolean actionLocked = false;
    private int speed = 0;
    private boolean hidden = false;
    private boolean isMoveable = false;
    private BufferedImage canvas;
    private Color[] cantCollide;

    //TODO FOR REVAMP
    private HashMap<HashMap<Integer, Integer>, Integer> irrelevantPoints;
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
        HashMap<Integer, Integer> points = new HashMap<>();
        for(int y=startY; y<(startY + 8); y++) {
            //Left foot points
            for(int xLeft=startX; xLeft<(startX + 8); xLeft++) {
                if(canvas.getRGB(xLeft, y) == Color.RED.getRGB()) {
                    points.put(xLeft, y);
                }
            }
            //Right foot points
            for(int xRight=rightFootStart; xRight<(rightFootStart + 8); xRight++) {
                if(canvas.getRGB(xRight, y) == Color.RED.getRGB()) {
                    points.put(xRight, y);
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
                if(canvas.getRGB(x, y) == Color.RED.getRGB()) {
                    points.put(x, y);
                }
            }
        }
        this.irrelevantPoints = new HashMap<>();
        this.irrelevantPoints.put(points, Color.RED.getRGB());


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
        //Add the points
        HashMap<Integer, Integer> eyePoints = new HashMap<>();
        for(int y=eyesStartY; y<(eyesStartY - 18); y++) {
            for(int xLeft = eyesStartX; xLeft<(eyesStartX + 5); xLeft++) {
                eyePoints.put(xLeft, y);
            }
            for(int xRight = (eyesStartX + 13); xRight<(eyesStartX + 13 + 5); xRight++) {
                eyePoints.put(xRight, y);
            }
        }
        this.irrelevantPoints.put(eyePoints, Color.BLACK.getRGB());


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
        int bottomMouthX = topMouthStartX + 1;
        int bottomMouthY = topMouthStartY + 3;
        //Add to irrelevant arrays
        HashMap<Integer, Integer> blackMouthPoints = new HashMap<>();
        HashMap<Integer, Integer> whiteMouthPoints = new HashMap<>();
        //Top
        for(int y=topMouthStartY; y<(topMouthStartY+2); y++) {
            for(int x=topMouthStartX; x<(topMouthStartX+9); x++) {
                if(canvas.getRGB(x, y) == Color.BLACK.getRGB()) {
                    blackMouthPoints.put(x, y);
                } else {
                    whiteMouthPoints.put(x, y);
                }
            }
        }
        //Bottom
        for(int y=bottomMouthY; y<(bottomMouthY+2); y++) {
            for(int x=bottomMouthX; x<(bottomMouthX+9); x++) {
                if(canvas.getRGB(x, y) == Color.BLACK.getRGB()) {
                    blackMouthPoints.put(x, y);
                } else {
                    whiteMouthPoints.put(x, y);
                }
            }
        }
        this.irrelevantPoints.put(whiteMouthPoints, Color.WHITE.getRGB());
        this.irrelevantPoints.put(blackMouthPoints, Color.BLACK.getRGB());

        //Arms arrays
        //Left
        this.leftArm = leftPoints;
        //Right
        this.rightArm = rightPoints;
    }

    @Override
    public void startGravity() {}

    @Override
    public boolean isMoveable() {
        return this.isMoveable;
    }

    @Override
    public void draw(Graphics g) {
        if(!this.hidden) {
            //Reset arms
            resetArms();
            //Draw it
            for (HashMap<Integer, Integer> hashmap : this.irrelevantPoints.keySet()) {
                int color = this.irrelevantPoints.get(hashmap);
                for (int x : hashmap.keySet()) {
                    int y = hashmap.get(x);
                    canvas.setRGB(x, y, color);
                    System.out.println("Drew line color: " + color);
                }
            }
            g.setColor(Color.RED);
            for (int x : this.leftArm.keySet()) {
                int y = this.leftArm.get(x);
                g.drawLine(x, y, x, y);
                //System.out.println("Drew line color: RED");
            }
            for (int x : this.rightArm.keySet()) {
                int y = this.rightArm.get(x);
                g.drawLine(x, y, x, y);
                //System.out.println("Drew line color: RED" );
            }
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
        //TODO
        return null;
    }

    @Override
    public int[] getPointsY() {
        //TODO
        return null;
    }

    @Override
    public boolean isActionLocked() {
        return this.actionLocked;
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

    private boolean armsMoved = false;
    private int armsYedited = 0;
    private int armsXedited = 0;
    public void resetArms() {
        if(this.armsMoved) {
            //Reset the arms back to old positions
        }
    }
    @Override
    public void jump() {
        //
    }

    @Override
    public void moveRight() {
        int moveRight = 5;
        int moveLeftArmDown = 3;
        int moveRightArmUp = 3;
        //IrrelevantPoints
        for(HashMap<Integer, Integer> hashmap : this.irrelevantPoints.keySet()) {
            for (Iterator it = hashmap.keySet().iterator(); it.hasNext(); ) {
                int x = (int) it.next();
                int y = hashmap.get(x);
                hashmap.put((x + moveRight), y);
                it.remove();
            }
        }
        //LeftArm
        for (Iterator it = this.leftArm.keySet().iterator(); it.hasNext();) {
            int x = (int) it.next();
            int y = this.leftArm.get(x);
            this.leftArm.put((x + moveRight), y); //Maybe make it go down a bit
        }
        //RightArm
        for (Iterator it = this.rightArm.keySet().iterator(); it.hasNext();) {
            int x = (int) it.next();
            int y = this.rightArm.get(x);
            this.rightArm.put((x + moveRight), y); //Maybe make it go up a bit
        }
    }

    @Override
    public void moveLeft() {
        //
    }
}
