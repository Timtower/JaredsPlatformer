package com.jaredscarito.jaredsplatformer.shapes;

import java.awt.*;

/**
 * Created by user on 11/28/2017.
 */
public interface Shape {
    int[] pointsX = null;
    int[] pointsY = null;
    Color color = null;
    boolean hidden = false;

    int[] getPointsX();


    int[] getPointsY();


    Color getColor();


    boolean collides(Shape shape1, Shape shape2);


    boolean collides(Shape shape1, Shape shape2, int pixels);


    void show();


    void hide();


    void draw(Graphics g);


    boolean isHidden();
}
