package com.test.gui;

import javax.swing.*;
import java.awt.*;

/**
 * BorderLayout 边界布局策略
 */
class BordTest extends JFrame{
    BordTest(){
        setSize(300, 200);
        setVisible(true);
        setTitle("边界布局示例");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //将其他组件加入到窗体
        add("East", new JButton("东"));
        add("South", new JButton("南"));
        add("West", new JButton("西"));
        add("North", new JButton("北"));
        //add("Center", new JButton("中"));
        validate();
    }
}

public class BorderLayoutTest {
    public static void main(String[] args) {
        new BordTest();
    }
}
