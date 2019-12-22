package com.t3h.models;

import com.t3h.utils.LoaderUtils;

import java.awt.*;

public class Player extends Tank{
    private int hp;
    private int score = 0;

    public Player(int x, int y, int hp) {
        super(x, y);
        this.hp = hp;
        orient = UP;
        images = new Image[4];
        images[LEFT] = LoaderUtils.getImage("player_green_left.png");
        images[RIGHT] = LoaderUtils.getImage("player_green_right.png");
        images[UP] = LoaderUtils.getImage("player_green_up.png");
        images[DOWN] = LoaderUtils.getImage("player_green_down.png");
    }
}
