package com.t3h.gui.main;

import com.t3h.gui.login.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    private String userName;
    private JLabel lbInfo;
    private JButton btnLogout;
    public MainPanel(String userName) {
        setLayout(null);
        setBackground(Color.WHITE);
        this.userName = userName;
        initComponents();
    }

    private void initComponents() {
        lbInfo = new JLabel();
        lbInfo.setText("Hi, " + userName);
        lbInfo.setSize(MainFrame.W_FRAME, 50);
        lbInfo.setLocation(0, 100);
        lbInfo.setFont(new Font(null, Font.BOLD, 30));
        lbInfo.setForeground(Color.RED);
        lbInfo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbInfo);

        btnLogout = new JButton();
        btnLogout.setText("Logout");
        btnLogout.setSize(MainFrame.W_FRAME - 40, 30);
        btnLogout.setLocation(10, 200);
        btnLogout.addActionListener(this);
        add(btnLogout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
