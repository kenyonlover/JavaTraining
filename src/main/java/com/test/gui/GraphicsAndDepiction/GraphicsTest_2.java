package com.test.gui.GraphicsAndDepiction;

import javax.swing.*;
import java.awt.*;

/**
 * 图形及描绘测试1：
 * 绘制多边形
 */
public class GraphicsTest_2 extends JFrame {
    GraphicsTest_2() {
        super("绘制多边形");
        setSize(300, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyCanvasPolygon p = new MyCanvasPolygon();
        add(p);
    }

    public static void main(String[] args) {
        new GraphicsTest_2();

    }
}

class MyCanvasPolygon extends Canvas {
    MyCanvasPolygon() {
        setSize(300, 250);

    }

    @Override
    public void paint(Graphics g) {
        int[] x = {80, 190, 150, 50};
        int[] y = {80, 30, 170, 210};
        int pts = x.length;
        g.drawPolygon(x, y, pts);//四个顶点坐标(x[1],y[1])，(x[2],y[2])...
    }
}