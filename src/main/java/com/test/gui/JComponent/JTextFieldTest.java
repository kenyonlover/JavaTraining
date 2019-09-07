package com.test.gui.JComponent;

import javax.swing.*;
import java.awt.*;

class TextField extends JFrame{
    JTextField txt;
    TextField(){
        setSize(300,200);
        setVisible(true);
        setTitle("创建文本框示例");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        txt = new JTextField(20);
        add(txt);
        validate();
        txt.setText("重新设置了文本");
    }
}

/**
 * JTextField文本框应用示例
 */
public class JTextFieldTest  {
    public static void main(String[] args) {
        new TextField();
    }
}
