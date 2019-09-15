package com.test.gui.GraphicsAndDepiction;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * 图形及描绘测试1：
 * 填充图形
 */
public class Graphics2DTest_2 extends JFrame {
    Graphics2DTest_2(){
        super("设置线条粗细");
        setSize(180,180);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyCanvas2DColor mc = new MyCanvas2DColor();
        add(mc);
    }

    public static void main(String[] args) {
        new Graphics2DTest_2();
    }
}

class MyCanvas2DColor extends Canvas{
    MyCanvas2DColor(){
        setSize(300,250);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        //创建渐变的颜色对象
        GradientPaint paint1 = new GradientPaint(0,10,Color.black,50,50,Color.yellow,false);
        //用渐变颜色设置画笔1
        graphics2D.setPaint(paint1);
        Rectangle2D rectangle2D_1 = new Rectangle2D.Double(0,10,50,50);
        //填充
        graphics2D.fill(rectangle2D_1);
        //创建渐变的颜色对象
        GradientPaint paint2 = new GradientPaint(60,60,Color.red,150,50,Color.white,true);
        //用渐变颜色设置画笔2
        graphics2D.setPaint(paint2);
        Rectangle2D rectangle2D_2 = new Rectangle2D.Double(60,60,150,50);
        //填充
        graphics2D.fill(rectangle2D_2);
    }
}