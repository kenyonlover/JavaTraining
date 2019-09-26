package com.test.thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 弹子台球
 * 设计一个多线程的应用程序，模拟一个台子上有多个弹子在上面滚动。弹子在碰到台子边缘时会被弹回来
 */
public class Billiards {
    public static void main(String[] args) {
        new Table();
    }
}

class Marble extends Thread {
    Table table = null;
    int x, y, xdir, ydir;

    public Marble(Table table, int x, int y, int xdir, int ydir) {
        this.table = table;
        this.x = x;//x坐标
        this.y = y;//y坐标
        this.xdir = xdir;//x方向速度
        this.ydir = ydir;//y方向速度
    }

    @Override
    public void run() {
        while (true) {
            if (x > (table.getSize().width) - 25 || (x < 0)) {
                xdir *= (-1);//超过台子x方向边界后，反方向运行
            }
            if (y > (table.getSize().height) - 25 || (y < 0)) {
                ydir *= (-1);
            }
            x += xdir;//坐标递增，实现移动
            y += ydir;
            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.repaint();//重绘图形
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);//弹子为黑色
        g.fillOval(x, y, 30, 30);//画圆
        g.setColor(Color.white);//弹子上的亮点为白色
        g.fillOval(x + 5, y + 5, 8, 6);//画亮点
    }
}

/**
 * 定义台球类
 */
class Table extends JFrame implements ActionListener {

    Button start = new Button("Start");
    Marble marbles[] = new Marble[5];//建立弹子线程类对象数组
    int v = 2;//速度最小值

    public Table() {
        super("弹子台球");
        setSize(300, 300);
        setBackground(Color.cyan);
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(start);
        start.addActionListener(this);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < marbles.length; i++) {
            //随机产生子弹的速度和坐标
            int xdir = i * (1 - i * (int) Math.round(Math.random())) + v;
            int ydir = i * (1 - i * (int) Math.round(Math.random())) + v;
            int x = (int) (getSize().width * Math.random());
            int y = (int) (getSize().height * Math.random());
            //实例化弹子线程对象
            marbles[i] = new Marble(this, x, y, xdir, ydir);
            marbles[i].start();
        }
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < marbles.length; i++) {
            if (marbles[i] != null) {
                marbles[i].draw(g);
            }
        }
    }
}
