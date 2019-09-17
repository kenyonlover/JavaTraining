package com.test.gui.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 焦点转移到下一组件演示
 */
public class Event_6_InputFocus extends JFrame implements KeyListener {
    JTextField[] t = new JTextField[4];

    Event_6_InputFocus(){
        setTitle("序列号输入程序");
        setSize(400,300);
        setVisible(true);
        setLayout(new FlowLayout());
        for (int i = 0; i <= 3; i++) {
            t[i] = new JTextField(10);
            add(t[i]);
            t[i].addKeyListener(this);
        }
        add(new JButton("下一步"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        validate();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (t[1].getText().length()==4){//假设5个字符（从0算起）
            t[1].transferFocus();//将焦点转移到下一个组件
        } else if (t[2].getText().length()==4){
            t[2].transferFocus();
        } else if(t[3].getText().length()==4){
            t[1].setText("序列号正在处理中");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new Event_6_InputFocus();
    }
}
