package com.t3h.manager;

import com.t3h.gui.MyFrame;
import com.t3h.models.Boss;
import com.t3h.models.Bullet;
import com.t3h.models.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private Player player;
    private ArrayList<Boss> arrBoss;
    private ArrayList<Bullet> arrBulletBoss;
    private ArrayList<Bullet> arrBulletPlayer;

    public void initGame() {
        player = new Player(300, 300, 3);
        arrBoss = new ArrayList<>();
        arrBulletBoss = new ArrayList<>();
        arrBulletPlayer = new ArrayList<>();
        initBoss();
    }

    private void initBoss() {
        if (arrBoss.size() <= 2) {
            arrBoss.add(new Boss(0, 0));
            arrBoss.add(new Boss(MyFrame.W_FRAME / 2 - 25, 0));
            arrBoss.add(new Boss(MyFrame.W_FRAME - 50, 0));
        }
    }

    public void draw(Graphics2D g2d) {
        for (Bullet b: arrBulletPlayer) {
            b.draw(g2d);
        }
        for (Bullet b: arrBulletBoss) {
            b.draw(g2d);
        }
        player.draw(g2d);
        for (Boss b: arrBoss) {
            b.draw(g2d);
        }
    }

    public void playerMove(int orient) {
        player.changeOrient(orient);
        player.move();
    }

    public void playerFire() {
        player.fire(arrBulletPlayer);
    }

    public void AI() {
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).createOrient();
            arrBoss.get(i).move();
            arrBoss.get(i).fire(arrBulletBoss);
        }
        moveBullet(arrBulletBoss);
        moveBullet(arrBulletPlayer);
    }

    private void moveBullet(ArrayList<Bullet> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            boolean out = arr.get(i).move();
            if (out) {
                arr.remove(i);
            }
        }
    }
}
