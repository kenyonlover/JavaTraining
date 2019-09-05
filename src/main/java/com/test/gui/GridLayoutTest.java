package com.test.gui;

import javax.swing.*;
import java.awt.*;

class GridTest extends JFrame{
    GridTest(){
        setSize(300, 200);
        setVisible(true);
        setTitle("网格布局示例");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));
        //下面通过循环构造一组按钮并加入到窗体中
        for (int i = 1; i <= 9 ; i++){
            add(new JButton("Button" + i));
        }
        validate();
    }
}

public class GridLayoutTest {
    public static void main(String[] args) {
        new GridTest();
    }
}
