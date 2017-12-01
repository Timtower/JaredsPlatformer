package com.jaredscarito.jaredsplatformer.storage;

import java.awt.*;

/**
 * Created by user on 12/1/2017.
 */
public class Storage {
    private int x;
    private int y;
    private Color color;
    public Storage(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public Color getColor() {
        return this.color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
