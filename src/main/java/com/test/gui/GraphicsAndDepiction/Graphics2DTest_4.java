package com.test.gui.GraphicsAndDepiction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 图形及描绘测试1：
 * 绘制一个可以移动的方块
 */
public class Graphics2DTest_4 extends JFrame implements ActionListener {
    //创建4个按钮
    private JButton left = new JButton("left");
    private JButton right = new JButton("right");
    private JButton up = new JButton("up");
    private JButton down = new JButton("down");

    //实例化画布，绘制图形块
    public MoveCanvas drawing = new MoveCanvas();

    //创建接收窗体事件适配器
    private class WindowCloser extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public Graphics2DTest_4(){
        super("移动方块");
        setSize(400,400);
        setVisible(true);
        Panel p =new Panel();
        p.setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        add(p,BorderLayout.SOUTH);
        add(drawing,BorderLayout.CENTER);
        p.add(up);
        p.add(down);
        p.add(left);
        p.add(right);
        validate();
        left.addActionListener(this);
        right.addActionListener(this);
        up.addActionListener(this);
        down.addActionListener(this);
        addWindowListener( new WindowCloser());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==up){
            drawing.moveUp();
        }else  if (e.getSource()==down){
            drawing.moveDown();
        }else  if (e.getSource()==left){
            drawing.moveLeft();
        }else  if (e.getSource()==right){
            drawing.moveRight();
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Graphics2DTest_4();
    }
}

/**
 * 创建一个绘制可移动的方块的画布类
 */
class MoveCanvas extends Canvas{
    //设置方块的大小，INC为每次移动方块的步长值
    int WIDTH = 30,HEIGHT = 30, INC = 10;
    int i,j;

    /**
     * 绘制红色黑边的方块，其位置随i,j变化，从而可以移动
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.drawRect(0,0,getSize().width-1,getSize().height-1);
        g.setColor(Color.black);
        g.fillRect(i+2,j+2,WIDTH+2,HEIGHT+2);
        g.setColor(Color.red);
        g.fillRect(i,j,WIDTH,HEIGHT);
    }

    /**
     * 图形块位置在垂直方向减少，从而实现图像块向上移动
     */
    public void moveUp(){
        if(j>0){
            j-=INC;
        }else{
            j=getSize().height-INC;
        }
        repaint();
    }

    /**
     * 图形块位置在垂直方向增加，从而实现图像块向下移动
     */
    public void moveDown(){
        if(j<getSize().height-INC){
            j+=INC;
        }else{
            j=0;
        }
        repaint();
    }

    /**
     * 图形块位置在水平方向减少，从而实现图像块向左移动
     */
    public void moveLeft(){
        if(i>0){
            i-=INC;
        }else{
            i=getSize().width-INC;
        }
        repaint();
    }

    /**
     * 图形块位置在水平方向增加，从而实现图像块向右移动
     */
    public void moveRight(){
        if(i<getSize().width-INC){
            i+=INC;
        }else{
            i=0;
        }
        repaint();
    }
}
