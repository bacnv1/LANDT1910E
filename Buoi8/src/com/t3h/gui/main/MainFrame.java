package com.t3h.gui.main;

import com.t3h.gui.login.LoginPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int W_FRAME = 300;
    public static final int H_FRAME = 500;

    public MainFrame(String userName) {
        setTitle("Main");
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        add(new MainPanel(userName));
    }
}
