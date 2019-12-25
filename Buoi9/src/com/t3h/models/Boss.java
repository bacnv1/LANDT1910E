package com.t3h.models;

import com.t3h.utils.LoaderUtils;

import java.awt.*;
import java.util.Random;

public class Boss extends Tank {
    private Random rd = new Random();

    public Boss(int x, int y) {
        super(x, y);
        orient = DOWN;
        images = new Image[4];
        images[LEFT] = LoaderUtils.getImage("bossyellow_left.png");
        images[RIGHT] = LoaderUtils.getImage("bossyellow_right.png");
        images[UP] = LoaderUtils.getImage("bossyellow_up.png");
        images[DOWN] = LoaderUtils.getImage("bossyellow_down.png");
    }

    public void createOrient() {
        int percent = rd.nextInt(101);
        if (percent >= 95) {
            int newOrient = rd.nextInt(4);
            changeOrient(newOrient);
        }
    }
}
