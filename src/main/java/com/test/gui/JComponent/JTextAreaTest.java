package com.test.gui.JComponent;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JTextArea 文本区
 */
public class JTextAreaTest {
    public static void main(String[] args) {
        new TextArea();
    }
}

class TextArea extends JFrame implements ActionListener {

    JTextArea txt1 = new JTextArea(7, 35);//创建文本区对象
    JTextField txt2 = new JTextField(35);//创建文本框对象
    String str = "窗外飘起蒙蒙小雨,\n平添一夜寒意,\n多少的思绪藏在心底.";

    TextArea(){
        setSize(400,200);
        setVisible(true);
        setTitle("文本组件示例");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        txt1.setText(str);
        add(txt1);
        add(txt2);
        validate();
        txt2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     String s = txt2.getText();
     txt1.append("\n"+s);
    }
}