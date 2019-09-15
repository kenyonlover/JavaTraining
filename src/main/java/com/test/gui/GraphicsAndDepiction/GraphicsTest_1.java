package com.test.gui.GraphicsAndDepiction;

import javax.swing.*;
import java.awt.*;

/**
 * 图形及描绘测试1：
 * 绘制直线、矩形、圆
 */
public class GraphicsTest_1 extends JFrame {
    GraphicsTest_1() {
        super("简单图形");
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyCanvas can = new MyCanvas();
        add(can);
    }

    public static void main(String[] args) {
        new GraphicsTest_1();
    }
}

class MyCanvas extends Canvas {
    MyCanvas() {
        setSize(300, 250);
    }

    /**
     * 重写绘制方法
     * 程序不会显示调用paint方法，它在main方法中被自行调用
     * @param e
     */
    @Override
    public void paint(Graphics e) {
        e.drawLine(50, 50, 120, 120);//直线
        e.drawRect(50, 50, 70, 70);//矩形
        e.drawOval(70, 70, 90, 90);//矩形的内接椭圆
    }

}