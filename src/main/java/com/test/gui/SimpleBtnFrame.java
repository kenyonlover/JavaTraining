package com.test.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 简单的按钮及图形界面
 */
class BtnIcon extends JFrame implements ActionListener {

    ImageIcon icon = new ImageIcon("win,jpg");
    JButton jbtn = new JButton("打开新窗体", icon);
    BtnIcon(){
        setSize(200, 200);
        setVisible(true);
        setTitle("按钮功能演示");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(jbtn);
        validate();
        jbtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame newf = new JFrame("新建窗体");
        newf.setSize(150, 150);
        newf.setVisible(true);
    }
}

public class SimpleBtnFrame{
    public static void main(String[] args) {
        new BtnIcon();
    }
}
