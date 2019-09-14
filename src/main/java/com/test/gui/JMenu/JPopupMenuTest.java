package com.test.gui.JMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 弹出式菜单测试
 */
public class JPopupMenuTest extends JFrame implements ActionListener {
    JPopupMenu popup = new JPopupMenu();//实例化弹出菜单
    JTextField txt = new JTextField(10);
    JMenuItem m1 = new JMenuItem("菜单项1");
    JMenuItem m2 = new JMenuItem("菜单项2");
    JMenuItem m3 = new JMenuItem("菜单项3");
    JMenuItem m4 = new JMenuItem("退出");
    public JPopupMenuTest(){
        super("右键弹出式菜单");
        setSize(300,250);
        setVisible(true);
        setLayout(new FlowLayout());
        add(txt);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        popup.add(m1);
        popup.add(m2);
        popup.add(m3);
        popup.addSeparator();
        popup.add(m4);
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        addMouseListener(new MouseAdapter() {//定义处理鼠标事件的匿名类
            @Override
            public void mouseClicked(MouseEvent e) {
                //在坐标处显示弹出右键菜单
                if(e.getButton()==MouseEvent.BUTTON3){
                    popup.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        txt.setText(((JMenuItem)e.getSource()).getText());//获取鼠标选中的菜单项文本
        if (e.getSource()==m4)
            System.exit(0);
    }

    public static void main(String[] args) {
        new JPopupMenuTest();
    }
}
