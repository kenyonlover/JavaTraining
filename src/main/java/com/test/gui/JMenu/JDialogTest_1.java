package com.test.gui.JMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 对话框测试
 */
public class JDialogTest_1 {
    public static void main(String[] args) {
        new Win();
    }
}

class Win extends JFrame implements ActionListener{

    JButton btn1 = new JButton("打开对话框");
    JTextArea txt = new JTextArea(5,8);
    Win(){
        super("对话框与窗体传递消息");
        setBounds(50,50,200,200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            //关闭窗体的另一种方法，构造窗口适配器匿名类
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setLayout(new BorderLayout());
        add(btn1,"North");
        add(txt,"Center");
        btn1.addActionListener(this);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //由于有模式的对话框，这时将产生阻塞，直到对话框关闭。窗体获取对话框传递的消息，放到文本区中
        Dia dia = new Dia(this, "传递消息对话框", true);
        dia.setVisible(true);
        txt.append(dia.getMessage());
    }
}

class Dia extends JDialog implements ActionListener{
    JTextField txt = new JTextField();
    //构造对话框，所依赖的窗体为f，对话框的标题为s，是否为有模式为b
    Dia(JFrame f, String s, boolean b){
        super(f, s, b);
        txt.setSize(200,80);
        setSize(300,100);
        setLayout(new FlowLayout());
        add(txt);
        txt.addActionListener(this);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public String getMessage(){
        return txt.getText();
    }
}