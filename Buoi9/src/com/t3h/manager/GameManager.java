package com.t3h.manager;

import com.t3h.gui.MyFrame;
import com.t3h.models.Boss;
import com.t3h.models.Bullet;
import com.t3h.models.Map;
import com.t3h.models.Player;
import com.t3h.utils.LoaderUtils;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private Player player;
    private ArrayList<Boss> arrBoss;
    private ArrayList<Bullet> arrBulletBoss;
    private ArrayList<Bullet> arrBulletPlayer;
    private ArrayList<Map> arrMap;
    private MapManager mapManager = new MapManager();

    public void initGame() {
        LoaderUtils.playSound("enter_game.wav");
        player = new Player(160, 460, 3);
        arrBoss = new ArrayList<>();
        arrBulletBoss = new ArrayList<>();
        arrBulletPlayer = new ArrayList<>();
        initBoss();
        arrMap = mapManager.readMap("map1.txt");
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
        for (Map m: arrMap) {
            m.draw(g2d);
        }
    }

    public void playerMove(int orient) {
        player.changeOrient(orient);
        player.move(arrMap);
    }

    public void playerFire() {
        player.fire(arrBulletPlayer);
    }

    public boolean AI() {
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).createOrient();
            arrBoss.get(i).move(arrMap);
            arrBoss.get(i).fire(arrBulletBoss);
            boolean die = arrBoss.get(i).checkDie(arrBulletPlayer);
            if (die) {
                arrBoss.remove(i);
                initBoss();
            }
        }
        return moveBullet(arrBulletBoss) ||
                moveBullet(arrBulletPlayer) ||
                player.checkDie(arrBulletBoss);
    }

    private boolean moveBullet(ArrayList<Bullet> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            boolean out = arr.get(i).move();
            if (out) {
                arr.remove(i);
            } else {
                for (int j = 0; j < arrMap.size(); j++) {
                    int bit = arrMap.get(j).getBit();
                    if (bit == 4 || bit == 2) {
                        continue;
                    }
                    Rectangle r = arrMap.get(j).getRect()
                            .intersection(arr.get(i).getRect());
                    if (r.isEmpty() == false) {
                        LoaderUtils.playSound("explosion.wav");
                        arr.remove(i);
                        if (bit != 5) {
                            arrMap.remove(j);
                        }
                        if (bit == 3) {
                            return true;
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }
}
