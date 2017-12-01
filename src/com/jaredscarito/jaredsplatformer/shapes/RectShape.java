package com.jaredscarito.jaredsplatformer.shapes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by user on 11/28/2017.
 */
public class RectShape extends ShapeCollideable implements Shape {
    private int[] pointsX = null;
    private int[] pointsY = null;
    private Color color = null;
    private boolean hidden = false;

    public RectShape(int startX, int startY, Color color, int width, int height, Graphics g, BufferedImage canvas) {
        g.setColor(color);
        g.drawRect(startX, startY, width, height);
        g.fillRect(startX, startY, width, height);
        this.color = color;
        ArrayList<Integer> pointsX = new ArrayList<>();
        ArrayList<Integer> pointsY = new ArrayList<>();
        for(int x=0; x<width; x++) {
            for(int y=0; y<height; y++) {
                if(canvas.getRGB(x, y) == color.getRGB()) {
                    //It's a pixel, add it
                    pointsX.add(x);
                    pointsY.add(y);
                }
            }
        }
        this.pointsX = new int[pointsX.size()];
        for(int i=0; i<pointsX.size(); i++) {
            this.pointsX[i] = pointsX.get(i);
        }
        this.pointsY = new int[pointsY.size()];
        for(int i=0; i<pointsY.size(); i++) {
            this.pointsY[i] = pointsY.get(i);
        }
    }

    @Override
    public void draw(Graphics g) {
        if(!this.hidden) {
            for (int pixelIndex = 0; pixelIndex < pointsX.length; pixelIndex++) {
                int pointX = this.pointsX[pixelIndex];
                int pointY = this.pointsY[pixelIndex];
                g.drawLine(pointX, pointY, pointX, pointY);
            }
        }
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
    public Color getColor() {
        return this.color;
    }

    @Override
    public void show() {
        this.hidden = false;
    }

    @Override
    public void hide() {
        this.hidden = true;
    }

    @Override
    public boolean isHidden() {
        return this.hidden;
    }
}
