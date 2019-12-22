package com.t3h.models;

import java.awt.*;

public abstract class Tank {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    protected Image[] images;
    protected int x;
    protected int y;
    protected int orient;
    protected int speed = 1;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images[orient], x, y, null);
    }

    public void changeOrient(int newOrient) {
        orient = newOrient;
    }

    public void move() {
        switch (orient) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
        }
    }
}
