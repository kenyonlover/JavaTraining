package com.test.gui.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * java焦点事件处理
 */
public class Event_5_Focus {
    public static void main(String[] args) {
        new FocusTest();
    }
}

class FocusTest extends JFrame{
    JTextField txt1,txt2;

    public FocusTest(){
        setTitle("焦点事件示例");
        setBounds(300,200,350,200);
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txt1 = new JTextField("",10);
        txt2 = new JTextField("",10);
        //设置焦点的监听，其监视对象中定义了得到焦点和失去焦点的方法
        txt1.addFocusListener(new txtFocus());
        txt2.addFocusListener(new txtFocus());
        add(txt1);
        add(txt2);

        add(new JButton("确定"));
        add(new JLabel("使用Tab键改变组件的焦点"));
        validate();
    }

    /**
     * 定义实现焦点监听接口的类
     */
    class txtFocus implements FocusListener{

        /**
         * 文本框得到焦点
         * @param e
         */
        @Override
        public void focusGained(FocusEvent e) {
            if(e.getSource()==txt1){
                txt1.setText("得到焦点");
            } else {
                txt2.setText("得到焦点");
            }
        }

        /**
         * 文本框失去焦点
         * @param e
         */
        @Override
        public void focusLost(FocusEvent e) {
            if(e.getSource()==txt1){
                txt1.setText("失去焦点");
            } else {
                txt2.setText("失去焦点");
            }
        }
    }
}
