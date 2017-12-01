package com.jaredscarito.jaredsplatformer.characters;

import com.jaredscarito.jaredsplatformer.objects.GameObject;
import com.jaredscarito.jaredsplatformer.storage.Storage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
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

    private ArrayList<Storage> irrPoints = new ArrayList<>();
    private ArrayList<Storage> leftArm = new ArrayList<>();
    private ArrayList<Storage> rightArm = new ArrayList<>();

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
        for(int y=startY; y<(startY + 8); y++) {
            //Left foot points
            for(int xLeft=startX; xLeft<(startX + 8); xLeft++) {
                this.irrPoints.add(new Storage(xLeft, y, Color.RED));
            }
            //Right foot points
            for(int xRight=rightFootStart; xRight<(rightFootStart + 8); xRight++) {
                this.irrPoints.add(new Storage(xRight, y, Color.RED));
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
                this.irrPoints.add(new Storage(x, y, Color.RED));
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
        //Add the points
        for(int y=eyesStartY; y<(eyesStartY + 5); y++) {
            for(int xLeft = eyesStartX; xLeft<(eyesStartX + 5); xLeft++) {
                this.irrPoints.add(new Storage(xLeft, y, Color.BLACK));
            }
            for(int xRight = (eyesStartX + 13); xRight<(eyesStartX + 13 + 5); xRight++) {
                this.irrPoints.add(new Storage(xRight, y, Color.BLACK));
            }
        }


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
        //add the points
        //Left
        for(int xLeft=armsStartX; xLeft<(armsStartX + 5); xLeft++) {
            for(int yLeft=armsStartY; yLeft<(armsStartY + 8); yLeft++) {
                this.leftArm.add(new Storage(xLeft, yLeft, Color.RED));
            }
        }
        //Right
        for(int xRight=(armsStartX + 28); xRight<(armsStartX + 5 + 28); xRight++) {
            for(int yRight=armsStartY; yRight<(armsStartY + 8); yRight++) {
                this.rightArm.add(new Storage(xRight, yRight, Color.RED));
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
        //Add to irrelevant array
        //Top
        for(int y=topMouthStartY; y<(topMouthStartY+2); y++) {
            for(int x=topMouthStartX; x<(topMouthStartX+9); x++) {
                if(canvas.getRGB(x, y) == Color.BLACK.getRGB()) {
                    this.irrPoints.add(new Storage(x, y, Color.BLACK));
                } else {
                    this.irrPoints.add(new Storage(x, y, Color.WHITE));
                }
            }
        }
        //Bottom
        for(int y=bottomMouthY; y<(bottomMouthY+2); y++) {
            for(int x=bottomMouthX; x<(bottomMouthX+9); x++) {
                if(canvas.getRGB(x, y) == Color.BLACK.getRGB()) {
                    this.irrPoints.add(new Storage(x, y, Color.BLACK));
                } else {
                    this.irrPoints.add(new Storage(x, y, Color.WHITE));
                }
            }
        }
        //System.out.println("irrelevantPoints HashMap Keyset: " + Arrays.toString(this.irrelevantPoints.keySet().toArray()));
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
            for(Storage pixel : this.irrPoints) {
                int x = pixel.getX();
                int y = pixel.getY();
                Color color = pixel.getColor();
                g.setColor(color);
                g.drawLine(x, y, x, y);
            }

            //Left Arm
            for(Storage pixel : this.leftArm) {
                int x = pixel.getX();
                int y = pixel.getY();
                Color color = pixel.getColor();
                g.setColor(color);
                g.drawLine(x, y, x, y);
            }
            //Right Arm
            for(Storage pixel : this.rightArm) {
                int x = pixel.getX();
                int y = pixel.getY();
                Color color = pixel.getColor();
                g.setColor(color);
                g.drawLine(x, y, x, y);
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
        //
    }

    @Override
    public void moveLeft() {
        //
    }
}
