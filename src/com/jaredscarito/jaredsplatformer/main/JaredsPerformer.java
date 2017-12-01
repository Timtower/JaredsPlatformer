package com.jaredscarito.jaredsplatformer.main;

import com.jaredscarito.jaredsplatformer.characters.GameCharacter;
import com.jaredscarito.jaredsplatformer.characters.Meatboy;
import com.jaredscarito.jaredsplatformer.draw.DrawableAdapter;
import com.jaredscarito.jaredsplatformer.draw.GameBoard;
import com.jaredscarito.jaredsplatformer.shapes.RectShape;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 11/28/2017.
 */
public class JaredsPerformer extends DrawableAdapter {
    public static JaredsPerformer ge = new JaredsPerformer();
    public static GameBoard gb = new GameBoard(ge, "Jared's Platformer");
    public static BufferedImage canvas;


    public static void main(String[] args) {
        gb.setSize(650, 500);
        canvas = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        fillCanvas(Color.YELLOW);
        showGameBoard(gb);
    }

    public static void fillCanvas(Color color) {
        for(int x=0; x<canvas.getWidth(); x++) {
            for(int y=0; y<canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color.getRGB());
            }
        }
    }

    private int currentStage = 1;
    private boolean started = false;
    private GameCharacter charact = null;
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(canvas, null, null);
        if(!this.started) {
            //Set start to true and draw the objects that can move:
            this.charact = new Meatboy(35, 450, g, canvas, 20, true, Color.GRAY);
            this.started = true;
        }
        drawStage(this.currentStage, g);
        this.charact.draw(g);
    }

    //Stage 1
    public void drawStage(int stage, Graphics g) {
        switch (stage) {
            case 1:
                RectShape rect = new RectShape(0, 470, Color.GRAY, 500, 30, g, canvas);
                rect.draw(g);
        }
    }

    //Keys
    @Override
    public void keyStruck(char c) {
        switch (c) {
            case 'W':
                charact.moveRight();
                break;
        }
    }
}
