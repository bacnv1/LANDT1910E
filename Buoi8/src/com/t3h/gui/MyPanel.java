package com.t3h.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    private JLabel lbTitle;
    private JTextField tfInfo;
    private JButton btnOk;

    public MyPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        initComponents();
    }

    private void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText("Hello World");
        lbTitle.setForeground(Color.RED);
        lbTitle.setSize(200, 100);
        lbTitle.setLocation(100, 100);
        lbTitle.setFont(new Font("Blackadder ITC", Font.BOLD, 20));
        add(lbTitle);

        tfInfo = new JTextField();
        tfInfo.setSize(200, 30);
        tfInfo.setLocation(100, 200);
        add(tfInfo);

        btnOk = new JButton();
        btnOk.setText("OK");
        btnOk.setSize(100, 30);
        btnOk.setLocation(100, 250);
        add(btnOk);

        btnOk.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnOk)) {
            JOptionPane.showMessageDialog(
                    null,
                    tfInfo.getText(),
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
