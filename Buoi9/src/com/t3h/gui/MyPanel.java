package com.t3h.gui;

import com.t3h.manager.GameManager;
import com.t3h.models.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener, Runnable {

    private GameManager manager = new GameManager();
    private boolean[] flag = new boolean[256];


    public MyPanel() {
        manager.initGame();
        setBackground(Color.BLACK);

        setFocusable(true);
        addKeyListener(this);

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        super.paintComponent(g2d);
        manager.draw(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        flag[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        flag[e.getKeyCode()] = false;
    }

    @Override
    public void run() {
        while (true) {
            if (flag[KeyEvent.VK_LEFT]) {
                manager.playerMove(Tank.LEFT);
            } else if (flag[KeyEvent.VK_RIGHT]) {
                manager.playerMove(Tank.RIGHT);
            } else if (flag[KeyEvent.VK_UP]) {
                manager.playerMove(Tank.UP);
            } else if (flag[KeyEvent.VK_DOWN]) {
                manager.playerMove(Tank.DOWN);
            }
            if (flag[KeyEvent.VK_SPACE]) {
                manager.playerFire();
            }
            boolean die = manager.AI();
            if (die) {
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Do you want to replay",
                        "Game Over",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (result == JOptionPane.YES_OPTION) {
                    manager.initGame();
                    flag = new boolean[256];
                } else {
                    System.exit(0);
                }
            }
            repaint();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
