package com.t3h.manager;

import com.t3h.models.Player;

import java.awt.*;

public class GameManager {
    private Player player;

    public void initGame() {
        player = new Player(300, 300, 3);
    }

    public void draw(Graphics2D g2d) {
        player.draw(g2d);
    }

    public void playerMove(int orient) {
        player.changeOrient(orient);
        player.move();
    }
}
