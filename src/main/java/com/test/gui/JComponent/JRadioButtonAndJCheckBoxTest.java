package com.test.gui.JComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * JRadioButtonAndJCheckBox 单选按钮及复选框测试
 */
public class JRadioButtonAndJCheckBoxTest {
    public static void main(String[] args) {
        new BRTest("单选按钮及复选框示例");
    }
}

class BRTest extends JFrame implements ItemListener,ActionListener{
    JTextField text = new JTextField(15);
    BRTest(String s){
        setSize(200,200);
        setVisible(true);
        setTitle(s);
        setLayout(new FlowLayout());
        //添加三个复选框
        JCheckBox cb1 = new JCheckBox("C");
        cb1.addItemListener(this);
        add(cb1);
        JCheckBox cb2 = new JCheckBox("C++");
        cb2.addItemListener(this);
        add(cb2);
        JCheckBox cb3 = new JCheckBox("Java");
        cb3.addItemListener(this);
        add(cb3);
        //添加三个单选按钮
        JRadioButton b1 = new JRadioButton("鲜花");
        b1.addActionListener(this);
        add(b1);
        JRadioButton b2 = new JRadioButton("掌声");
        b2.addActionListener(this);
        add(b2);
        JRadioButton b3 = new JRadioButton("鸡蛋");
        b3.addActionListener(this);
        add(b3);
        //定义按钮组，单选按钮只有放到按钮组中才能实现单选功能
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        //添加文本框
        add(text);
        validate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text.setText(e.getActionCommand());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox cb = (JCheckBox) e.getItem();
        text.setText(cb.getText());
    }
}
