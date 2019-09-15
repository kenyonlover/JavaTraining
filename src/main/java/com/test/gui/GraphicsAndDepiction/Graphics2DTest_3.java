package com.test.gui.GraphicsAndDepiction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 图形及描绘测试1：
 * 随机生成一个多边形
 */
public class Graphics2DTest_3 extends JFrame implements ActionListener {
    OvalCanvas canvas;//声明画布对象
    TextField in_N;//接收用户输入的数据
    Button btn;

    Graphics2DTest_3() {
        super("画布上绘制多边形");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        in_N = new TextField(6);
        setLayout(new FlowLayout());
        add(new Label("请输入边数："));
        add(in_N);
        btn = new Button("确定");
        btn.addActionListener(this);
        add(btn);
        //创建画布对象并添加到窗体中
        canvas = new OvalCanvas();
        add(canvas);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int N = Integer.parseInt(in_N.getText());//将文本框中的字符数字装换成整形
        int x[] = new int[N];
        int y[] = new int[N];
        for (int i = 0; i < N; i++) {
            //随机产生多边形各折线的坐标值
            x[i] = (int) (Math.random() * 200);
            y[i] = (int) (Math.random() * 200);
        }
        canvas.setOval(x, y, N);//传值到画布对象，绘制多边形
        canvas.repaint();//重绘
    }

    public static void main(String[] args) {
        new Graphics2DTest_3();
    }
}

class OvalCanvas extends Canvas {
    //设置多边形数的最大值
    int N = 10;
    //x,y为左边位置数组
    int[] x = new int[N];
    int[] y = new int[N];

    OvalCanvas() {
        setSize(300, 200);
        setBackground(Color.cyan);
    }

    /**
     * 用于传递多边形的位置及边数
     *
     * @param x
     * @param y
     * @param N
     */
    public void setOval(int[] x, int[] y, int N) {
        this.N = N;
        for (int i = 0; i < N; i++) {
            this.x[i] = x[i];
            this.y[i] = y[i];
        }
    }

    @Override
    public void paint(Graphics g) {
        //绘制多边形
        g.drawPolygon(x, y, N);
    }
}