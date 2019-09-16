package com.test.gui.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 实现鼠标事件处理的三个接口
 */
public class Event_1_Mouse implements MouseMotionListener, MouseListener, WindowListener {
    JFrame win;
    JTextField text;

    public static void main(String[] args) {
        Event_1_Mouse mouse = new Event_1_Mouse();
        mouse.toWin();
    }

    public void toWin() {
        //构建窗体
        win = new JFrame("实现三个接口的示例");
        win.setSize(300, 400);
        win.setVisible(true);
        win.add(new Label("点击并拖拽鼠标===>Click and drag the mouse"), "North");
        text = new JTextField(30);
        win.add(text, "South");//使用默认的边界布局管理器
        win.addMouseMotionListener(this);//注册监听器MouseMotionListener
        win.addMouseListener(this);//注册监听器MouseListener
        win.addWindowListener(this);//注册监听器WindowListener
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * 鼠标进入
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        String s = "鼠标进入";
        text.setText(s);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        String s = "鼠标离开";
        text.setText(s);
    }

    /**
     * 拖拽鼠标
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        String s = "拖拽鼠标：X = " + e.getX() + " Y = " + e.getY();
        text.setText(s);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * 为了使窗口能正常关闭，程序正常退出，需要实现windowClosing方法
     * @param e
     */
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
