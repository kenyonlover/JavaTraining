package com.test.gui.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * 使用匿名类作鼠标移动事件适配器
 */
public class Event_3_MouseAdapter {
    JFrame win;
    JTextField text;

    public Event_3_MouseAdapter(){
        win = new JFrame("匿名类作鼠标移动事件适配器");
        text = new JTextField(30);
    }

    public void inFrame(){
        JLabel label = new JLabel("Click and drag the mouse...");
        win.add(label, BorderLayout.NORTH);
        win.add(text, BorderLayout.SOUTH);
        //参数为内部类对象
        win.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                String s = "Mouse dragging: x = " + e.getX() + " y = " + e.getY();
                text.setText(s);
            }
        });
        win.setSize(300,200);
        win.setVisible(true);
    }

    public static void main(String[] args) {
        Event_3_MouseAdapter adapter = new Event_3_MouseAdapter();
        adapter.inFrame();
    }
}
