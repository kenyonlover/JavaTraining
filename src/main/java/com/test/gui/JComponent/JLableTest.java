package com.test.gui.JComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JLable 标签
 */
public class JLableTest {
    public static void main(String[] args) {
        new LbTest("有图标的按钮和标签");
    }
}

class LbTest extends JFrame implements ActionListener{

    LbTest(String s){
        setSize(300,200);
        setVisible(true);
        setTitle(s);
        setLayout(new FlowLayout());
        ImageIcon icon1 = new ImageIcon("s1.jpg");
        ImageIcon icon2 = new ImageIcon("s2.jpg");
        ImageIcon icon3 = new ImageIcon("s3.jpg");
        JButton jbtn = new JButton("我是按钮",icon1);
        jbtn.setRolloverIcon(icon2);//当鼠标停留在按钮上时变换图标
        JLabel jlb = new JLabel("我是标签",icon3,SwingConstants.CENTER);
        jlb.setToolTipText("QQ头像");//当鼠标停留在标签上时显示提示文本
        add(jbtn);
        add(jlb);
        jbtn.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JInternalFrame in_window;//声明内部窗体对象
        in_window = new JInternalFrame("内部窗体",true,true,true,true);
        in_window.setSize(250,200);
        in_window.setVisible(true);
        add(in_window);
        JTextArea text = new JTextArea(5,15);//创建文本区对象
        in_window.add(text,BorderLayout.CENTER);//按边界布局添加到窗体中
    }
}