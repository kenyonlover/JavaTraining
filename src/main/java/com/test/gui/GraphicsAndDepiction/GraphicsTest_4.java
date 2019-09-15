package com.test.gui.GraphicsAndDepiction;

import javax.swing.*;
import java.awt.*;

/**
 * 图形及描绘测试1：
 * 字体
 */
public class GraphicsTest_4 extends JFrame {
    public GraphicsTest_4() {
        super("字体");
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyCanvasFont mf = new MyCanvasFont();
        add(mf);
    }

    public static void main(String[] args) {
        new GraphicsTest_4();
    }
}

class MyCanvasFont extends Canvas {
    String[] FONTS = {"Dialog", "DialogInput", "Monospaced", "Serif", "SansSerif"};
    String TEXT = "一个逻辑字体的示例";

    MyCanvasFont() {
        setSize(300, 300);
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < FONTS.length; i++) {
            g.setFont(new Font(FONTS[i], Font.PLAIN, 12));
            g.drawString(FONTS[i] + "(plain:)" + TEXT, 10, 20 * i + 40);
        }
        for (int i = 0; i < FONTS.length; i++) {
            g.setFont(new Font(FONTS[i], Font.BOLD + Font.ITALIC, 14));
            g.drawString(FONTS[i] + "(bold,italics)" + TEXT, 10, 20 * i + 180);
        }
    }
}
