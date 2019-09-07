package com.test.gui.JComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PassWordFild extends JFrame implements ActionListener{

    JLabel lb = new JLabel("请输入密码：");
    JPasswordField txt1 = new JPasswordField(25);
    JButton bn = new JButton("确定");
    JTextField txt2 = new JTextField(25);
    PassWordFild(){
        setSize(300,200);
        setVisible(true);
        setTitle("密码验证");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(lb);
        add(txt1);
        txt1.setEchoChar('*');
        add(bn);
        add(txt2);
        validate();
        bn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (txt1.getText().equals("abc"))
            txt2.setText("密码正确");
        else
            txt2.setText("密码错误");
    }
}

/**
 * JPassWordFild 密码框
 */
public class JPassWordFildTest {
    public static void main(String[] args) {
        new PassWordFild();
    }
}
