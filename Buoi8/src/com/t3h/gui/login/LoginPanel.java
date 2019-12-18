package com.t3h.gui.login;

import com.t3h.gui.main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener {
    private JLabel lbTitle;
    private JTextField tfUserName;
    private JPasswordField tfPassword;
    private JButton btnLogin;
    private JButton btnExit;
    public LoginPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        initComponents();
    }

    private void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText("Login");
        lbTitle.setLocation(0, 20);
        lbTitle.setSize(LoginFrame.W_FRAME, 50);
        lbTitle.setFont(new Font(null, Font.BOLD, 20));
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbTitle);

        tfUserName = new JTextField();
        tfUserName.setLocation(10, 100);
        tfUserName.setSize(LoginFrame.W_FRAME - 40, 30);
        add(tfUserName);

        tfPassword = new JPasswordField();
        tfPassword.setLocation(10, 150);
        tfPassword.setSize(LoginFrame.W_FRAME - 40, 30);
        add(tfPassword);

        int haftWidth = LoginFrame.W_FRAME / 2 - 30;
        btnLogin = new JButton();
        btnLogin.setText("Login");
        btnLogin.setLocation(10, 200);
        btnLogin.setSize(haftWidth, 30);
        add(btnLogin);
        btnLogin.addActionListener(this);

        btnExit = new JButton();
        btnExit.setText("Exit");
        btnExit.setLocation(10 + haftWidth + 15, 200);
        btnExit.setSize(haftWidth, 30);
        add(btnExit);
        btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnExit)) {
            System.exit(0);
        } else if (e.getSource().equals(btnLogin)) {
            String userName = tfUserName.getText();
            String password = tfPassword.getText();
            if (userName.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Input is empty",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            MainFrame main = new MainFrame(userName);
            main.setVisible(true);
            SwingUtilities.getWindowAncestor(this).dispose();
        }
    }
}
