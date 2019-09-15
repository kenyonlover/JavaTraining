package com.test.gui.GraphicsAndDepiction;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * 图形及描绘测试1：
 * 控制线条粗细
 */
public class Graphics2DTest_1 extends JFrame {
    Graphics2DTest_1(){
        super("设置线条粗细");
        setSize(300,250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyCanvas2DLineThickness lt = new MyCanvas2DLineThickness();
        add(lt);
    }

    public static void main(String[] args) {
        new Graphics2DTest_1();
    }
}

class MyCanvas2DLineThickness extends Canvas{
    MyCanvas2DLineThickness(){
        setSize(300,250);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        //创建直线对象
        Line2D line1 = new Line2D.Double(150,50,220,150);
        Line2D line2 = new Line2D.Double(150,50,80,150);
        Line2D line3 = new Line2D.Double(80,150,220,150);
        //创建线条粗细对象
        BasicStroke basicStroke1 = new BasicStroke(16,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
        BasicStroke basicStroke2 = new BasicStroke(16f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
        BasicStroke basicStroke3 = new BasicStroke(16f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        //设置线条形状
        graphics2D.setStroke(basicStroke1);
        graphics2D.setStroke(basicStroke2);
        graphics2D.setStroke(basicStroke3);
        //绘制直线
        graphics2D.draw(line1);
        graphics2D.draw(line2);
        graphics2D.draw(line3);
    }
}
