package com.test.gui.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * 事件适配器及内部类示例
 */
public class Event_2_Adapter {
    JFrame win;
    JTextField text;

    public Event_2_Adapter() {
        win = new JFrame("事件适配器及内部类示例");
        text = new JTextField(30);
    }

    public void inFrame() {
        JLabel label = new JLabel("Click and drag the mouse...");
        win.add(label, BorderLayout.NORTH);
        win.add(text, BorderLayout.SOUTH);
        //参数为内部类对象
        win.addMouseMotionListener(new MyMouseMotionListener());
        win.setSize(300,200);
        win.setVisible(true);
    }

    class MyMouseMotionListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            String s = "Mouse dragging: x = " + e.getX() + " y = " + e.getY();
            text.setText(s);
        }
    }

    public static void main(String[] args) {
        Event_2_Adapter mouseAdapter = new Event_2_Adapter();
        mouseAdapter.inFrame();
    }
}
