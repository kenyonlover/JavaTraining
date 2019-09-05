package com.test.gui;

import javax.swing.*;
import java.awt.*;

/**
 * 面板JPanel测试，使用浮动布局策略（FlowLayout）
 */
class PanelTest extends JFrame {
    Panel panel1 = new Panel();
    Panel panel2 = new Panel();
    Button button1 = new Button("Button1");
    Button button2 = new Button("Button2");
    Button button3 = new Button("Button3");
    Button button4 = new Button("Button4");
    PanelTest(){
        setSize(200, 150);
        setVisible(true);
        setTitle("面板容器示例");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        //将面板容器加入到窗体中
        add(panel1);
        add(panel2);
        //将其他组件加入到面板容器中
        panel1.add(button1);
        panel1.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.cyan);
        validate();
    }
}

public class SimplePanel {
    public static void main(String[] args) {
        new PanelTest();
    }
}
