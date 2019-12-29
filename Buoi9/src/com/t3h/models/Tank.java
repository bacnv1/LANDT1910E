package com.t3h.models;

import com.t3h.gui.MyFrame;
import com.t3h.utils.LoaderUtils;

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

    public void move(ArrayList<Map> arrMap) {
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
        if (checkMap(arrMap) == false) {
            x = xR;
            y = yR;
            return;
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

    private boolean checkMap(ArrayList<Map> arrMap) {
        for (Map m: arrMap) {
            if (m.getBit() == 4) {
                continue;
            }
            Rectangle r = m.getRect().intersection(getRect());
            if (r.isEmpty() == false) {
                return false;
            }
        }
        return true;
    }

    public void fire(ArrayList<Bullet> arr) {
        long T = System.currentTimeMillis();
        if (T - t >= 500) {
            if (this instanceof Player) {
                LoaderUtils.playSound("shoot.wav");
            }
            int xB = x + images[orient].getWidth(null) / 2;
            int yB = y + images[orient].getHeight(null) / 2;
            Bullet b = new Bullet(xB, yB, orient);
            arr.add(b);
            t = T;
        }
    }

    public boolean checkDie(ArrayList<Bullet> bullets) {
        for (int i = 0; i < bullets.size(); i++) {
            Rectangle r = bullets.get(i).getRect()
                    .intersection(getRect());
            if (r.isEmpty() == false) {
                bullets.remove(i);
                LoaderUtils.playSound("explosion_tank.wav");
                return true;
            }
        }
        return false;
    }

    public Rectangle getRect(){
        int w = images[orient].getWidth(null);
        int h = images[orient].getHeight(null);
        int r = 0;
        int b = 0;
        if (orient == UP || orient == DOWN) {
            r = 1;
        } else {
            b = 2;
        }
        return new Rectangle(x, y, w - r, h - b);
    }
}
