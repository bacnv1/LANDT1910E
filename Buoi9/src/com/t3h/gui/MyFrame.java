package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public static final int W_FRAME = 510;
    public static final int H_FRAME = 533;

    public MyFrame() {
        setTitle("Tank 90");
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new MyPanel());
    }
}
