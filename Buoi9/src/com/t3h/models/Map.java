package com.t3h.models;

import com.t3h.utils.LoaderUtils;

import java.awt.*;

public class Map {
    private int x;
    private int y;
    private Image[] images = {
            LoaderUtils.getImage("brick.png"),
            LoaderUtils.getImage("water.png"),
            LoaderUtils.getImage("bird.png"),
            LoaderUtils.getImage("tree.png"),
            LoaderUtils.getImage("rock.png"),
    };
    private int bit;

    public Map(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    public void draw(Graphics2D g2d) {
        if (bit == 3) {
            g2d.drawImage(images[bit - 1], x, y,
                    38, 38, null);
        } else {
            g2d.drawImage(images[bit - 1], x, y, null);
        }
    }

    public Rectangle getRect() {
        int w = images[bit - 1].getWidth(null);
        int h = images[bit - 1].getHeight(null);
        if (bit == 3) {
            w = h = 38;
        }
        return new Rectangle(x, y, w, h);
    }

    public int getBit() {
        return bit;
    }
}
