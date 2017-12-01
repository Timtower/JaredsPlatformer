package com.jaredscarito.jaredsplatformer.shapes;

import java.awt.*;

/**
 * Created by user on 11/28/2017.
 */
public class ArcShape extends ShapeCollideable implements Shape {
    private int[] pointsX = null;
    private int[] pointsY = null;
    private Color color = null;
    private boolean hidden = false;




    @Override
    public void draw(Graphics g) {
        for(int pixelIndex=0; pixelIndex < pointsX.length; pixelIndex++) {
            int pointX = this.pointsX[pixelIndex];
            int pointY = this.pointsY[pixelIndex];
            g.drawLine(pointX, pointY, pointX, pointY);
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
