package com.test.io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 对象流的应用
 */
public class ObjectStream_1 {
    public static void main(String[] args) {
        new ObjectRW();
    }
}

class ObjectRW extends JFrame implements ActionListener{

    Ball ball_Panel = null;
    FileInputStream file_in = null;
    FileOutputStream file_out = null;
    ObjectInputStream object_in = null;
    ObjectOutputStream object_out = null;
    JButton readBtn = null, writeBtn = null;

    ObjectRW(){
        setTitle("对象流示例");
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ball_Panel = new Ball();
        readBtn = new JButton("读取对象");
        writeBtn = new JButton("写入对象");
        Panel p = new Panel();
        add(ball_Panel,"Center");
        add(p,"South");
        p.setLayout(new FlowLayout());
        p.add(writeBtn);
        p.add(readBtn);
        readBtn.addActionListener(this);
        writeBtn.addActionListener(this);
        readBtn.setEnabled(false);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==writeBtn){
            try {
                file_out = new FileOutputStream("ball.dat");
                object_out = new ObjectOutputStream(file_out);
                object_out.writeObject(ball_Panel);//将ball_Panel对象写入对象流
                object_out.close();
                readBtn.setEnabled(true);
                this.validate();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource()==readBtn){
            try {
                file_in =  new FileInputStream("ball.dat");
                object_in = new ObjectInputStream(file_in);
                Ball temp_Panel = (Ball) object_in.readObject();
                JFrame win = new JFrame("读取对象流");
                win.setBounds(200,200,300,300);
                win.setVisible(true);
                win.add(temp_Panel);
                object_in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}

/**
 * 球对象面板
 */
class Ball extends Panel{
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(50,50,30,30);
        g.setColor(Color.white);
        g.fillOval(55,55,8,6);
    }
}