package com.test.gui.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 使用键盘方向键移动按钮组件
 */
public class Event_4_Key extends JFrame implements KeyListener {
    JButton b[] = new JButton[3];
    int x, y;//记录按钮的坐标位置

    public Event_4_Key() {
        setSize(300, 300);
        setVisible(true);
        setLayout(new FlowLayout());
        for (int i = 0; i < 3; i++) {
            b[i] = new JButton("" + i);
            b[i].addKeyListener(this);
            add(b[i]);
        }
        validate();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 处理键盘事件
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        JButton button = (JButton) e.getSource();//获取事件源并强制转换为按钮类型
        x = button.getBounds().x;
        y = button.getBounds().y;
        if (e.getKeyCode() == KeyEvent.VK_UP) {//VK_UP表示按下“向上”的方向键
            y = y - 2;
            if (y <= 0) {
                y = 300;
            }
            button.setLocation(x, y);
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {//VK_UP表示按下“向下”的方向键
            y = y + 2;
            if (y > 300) {
                y = 0;
            }
            button.setLocation(x, y);
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {//VK_UP表示按下“向左”的方向键
            x = x - 2;
            if (x <= 0) {
                x = 30;
            }
            button.setLocation(x, y);
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {//VK_UP表示按下“向右”的方向键
            x = x + 2;
            if (x > 300) {
                x = 0;
            }
            button.setLocation(x, y);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        Event_4_Key key = new Event_4_Key();
        key.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
