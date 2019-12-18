package com.t3h.gui.login;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public static final int W_FRAME = 300;
    public static final int H_FRAME = 500;

    public LoginFrame() throws HeadlessException {
        setTitle("Login");
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        add(new LoginPanel());
    }
}
