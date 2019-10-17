package com.test.net;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class C_client extends JFrame implements ActionListener {

    JTextArea txt1;
    JButton btn;
    JPanel p;
    int srvPort;//服务器端口
    DataInputStream in = null;//数据输入流
    DataOutputStream out = null;//数据输出流
    Socket c_socket;//套接字
    InputStream in_data;//接收到的输入流
    OutputStream out_data;//发送的输出流
    String str;//存放接收的数据
    int i=0;//计数
    JTextField txtPort;
    JLabel lb;

    C_client(){
        super("客户端");
        setSize(300,200);
        setVisible(true);
        txt1 = new JTextArea(5,4);
        add(txt1, BorderLayout.CENTER);
        p = new JPanel();
        add(p,BorderLayout.NORTH);
        lb = new JLabel("连接服务器端口：");
        txtPort = new JTextField(10);
        btn = new JButton("连接");
        p.add(lb);
        p.add(txtPort);
        p.add(btn);
        btn.addActionListener(this);
        validate();
    }

    public static void main(String[] args) {
        new C_client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        srvPort = Integer.parseInt(txtPort.getText());
        try {
            c_socket = new Socket("127.0.0.1",srvPort);
        } catch (IOException e1) {
            System.out.println("找不到服务器！！\n e1 = [" + e1 + "]");
            e1.printStackTrace();
        }
        try {
            in_data = c_socket.getInputStream();
            out_data = c_socket.getOutputStream();
            in = new DataInputStream(in_data);
            out = new DataOutputStream(out_data);
            //获取对方及本机的端口号
            int p1 = c_socket.getPort();
            int p2 = c_socket.getLocalPort();
            txt1.append("获取到对方的端口号： " + p1 + "\n");
            txt1.append("获取到本机的端口号： " + p2 + "\n");
        } catch (IOException e1) {
            System.out.println("建立输入输出流错误！！ \n e1 = [" + e1 + "]");
            e1.printStackTrace();
        }
        try {
            str = in.readUTF();
            txt1.append("客户收到："+str + "\n");
            if (i>10){
                out.writeUTF("end");//发出end信息，关闭连接
                in.close();
                out.close();
                c_socket.close();
                System.exit(0);
            } else {
                out.writeUTF("I am Client");
                i++;
            }
        } catch (IOException e1) {
            System.out.println("线路读写出错！！ \n e1 = [" + e1 + "]");
            e1.printStackTrace();
        }
    }
}
