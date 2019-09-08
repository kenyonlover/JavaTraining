package com.test.gui.JComponent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * JSlider JProgressBar 滑杆和进度指示条
 */
public class JSliderAndJProgressBarTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("滑杆和进度指示条");
        f.setSize(300,150);
        f.add(new P());
        f.show();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class P extends JPanel{
    JProgressBar pb = new JProgressBar();//进度条
    JSlider sb =new JSlider(JSlider.HORIZONTAL,0,100,60);
    public P(){
        setLayout(new FlowLayout());
        add(pb);
        sb.setValue(0);
        sb.setPaintTicks(true);
        sb.setMajorTickSpacing(20);
        sb.setMinorTickSpacing(5);
        sb.setBorder(new TitledBorder("移动滑杆"));
        pb.setModel(sb.getModel());
        pb.setStringPainted(true);
        add(sb);
    }
}