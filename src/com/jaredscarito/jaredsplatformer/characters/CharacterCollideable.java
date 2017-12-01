package com.jaredscarito.jaredsplatformer.characters;

import com.jaredscarito.jaredsplatformer.objects.GameObject;

import java.awt.*;

/**
 * Created by user on 11/30/2017.
 */
public class CharacterCollideable {
    public boolean collides(Shape shape, int pixels) {
        return false;
    }

    public boolean collides(GameObject obj) {
        return false;
    }

    public boolean collides(GameObject obj, int pixels) {
        return false;
    }

    public boolean collides(Shape shape) {
        return false;
    }
}
