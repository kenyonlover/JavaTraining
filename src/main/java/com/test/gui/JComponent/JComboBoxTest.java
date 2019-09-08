package com.test.gui.JComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *  JComboBox 下拉列表测试
 */
public class JComboBoxTest {
    public static void main(String[] args) {
        new CobTest("下拉列表示例");
    }
}

class CobTest extends JFrame implements ItemListener{

    JLabel jlb;
    ImageIcon frace,italy,chana;
    CobTest(String s){
        setSize(300,200);
        setVisible(true);
        setTitle(s);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JComboBox jc = new JComboBox();
        jc.addItem("s1");
        jc.addItem("s2");
        jc.addItem("s3");
        jc.addItemListener(this);
        add(jc);
        jlb = new JLabel(new ImageIcon("s1.jpg"));
        add(jlb);
        validate();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String s = e.getItem().toString();
        jlb.setIcon(new ImageIcon(s+".jpg"));
    }
}
