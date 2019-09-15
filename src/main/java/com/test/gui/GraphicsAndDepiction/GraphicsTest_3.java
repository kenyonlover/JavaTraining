package com.test.gui.GraphicsAndDepiction;

import javax.swing.*;
import java.awt.*;

/**
 * 图形及描绘测试1：
 * 绘制用色彩填充的笑脸图形
 */
public class GraphicsTest_3 extends JFrame {
    public  GraphicsTest_3(){
        super("笑脸");
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyCacvasColor mc = new MyCacvasColor();
        add(mc);
    }

    public static void main(String[] args) {
        new GraphicsTest_3();
    }
}

class MyCacvasColor extends Canvas {
    MyCacvasColor() {
        setSize(300, 300);
    }

    @Override
    public void paint(Graphics g) {
        //先设置颜色，然后画填充的圆，得到一个黄色的圆
        g.setColor(Color.yellow);
        g.fillOval(35, 30, 210, 210);
        //先设置黑色，再画圆弧（填充），得到一个黑色的半圆
        g.setColor(Color.black);
        g.fillArc(70, 70, 150, 150, 180, 180);
        //画一个稍小些的黄色圆弧，覆盖黑色半圆，构成嘴巴
        g.setColor(Color.yellow);
        g.fillArc(70, 75, 150, 130, 180, 180);
        //先设置黑色，再画两个圆，得到两个黑色的小眼睛
        g.setColor(Color.black);
        g.fillOval(80, 100, 30, 30);
        g.fillOval(180, 100, 30, 30);
    }
}