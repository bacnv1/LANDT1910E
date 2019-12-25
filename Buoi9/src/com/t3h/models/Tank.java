package com.t3h.models;

import com.t3h.gui.MyFrame;

import java.awt.*;
import java.util.ArrayList;

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
    private long t;

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
        int xR = x;
        int yR = y;
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
        int w = images[orient].getWidth(null);
        int h = images[orient].getHeight(null);
        if (x < 0 || x > MyFrame.W_FRAME - w - 16) {
            x = xR;
        }
        if (y < 0 || y > MyFrame.H_FRAME - h - 40) {
            y = yR;
        }
    }

    public void fire(ArrayList<Bullet> arr) {
        long T = System.currentTimeMillis();
        if (T - t >= 500) {
            int xB = x + images[orient].getWidth(null) / 2;
            int yB = y + images[orient].getHeight(null) / 2;
            Bullet b = new Bullet(xB, yB, orient);
            arr.add(b);
            t = T;
        }
    }
}
