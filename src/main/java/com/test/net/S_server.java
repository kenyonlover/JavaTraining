package com.test.net;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class S_server extends JFrame implements ActionListener,Runnable {

    ServerSocket s_socket;//服务器端套接字
    Socket c_socket;//套接字
    DataInputStream in = null;//数据输入流
    DataOutputStream out = null;//数据输出流
    InputStream in_data;//接收到的输入流
    OutputStream out_data;//发送的输出流
    int i = 0;//计数
    int srvPort;//服务器端口号
    JTextArea txt1;
    JTextField txtPort;
    JButton btn;
    JPanel p;
    JLabel lb;
    String str;

    S_server(){
        super("服务器");
        setSize(300,200);
        setVisible(true);
        txt1 = new JTextArea(5,4);
        add(txt1, BorderLayout.CENTER);
        p = new JPanel();
        add(p,BorderLayout.NORTH);
        lb = new JLabel("设置端口：");
        txtPort = new JTextField(10);
        btn = new JButton("监听端口");
        p.add(lb);
        p.add(txtPort);
        p.add(btn);
        validate();
        btn.addActionListener(this);
    }

    public static void main(String[] args) {
        new S_server();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        srvPort = Integer.parseInt(txtPort.getText());
        try {
            s_socket = new ServerSocket(srvPort);
            while (true){
                c_socket = s_socket.accept();
                Thread t = new Thread(this);
                t.start();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public  void run(){
        try {
            while (true){
                in_data =c_socket.getInputStream();
                out_data = c_socket.getOutputStream();
                in = new DataInputStream(in_data);
                out = new DataOutputStream(out_data);
                out.writeUTF("你好，我是服务器");
                str = in.readUTF();
                if (str.equals("end")){
                    in.close();
                    out.close();
                    c_socket.close();
                }
                txt1.append("第"+i+"个客户发来"+str+"\n");
                Thread.sleep(200);
            }
        } catch (IOException e) {
            System.out.println("线路上读写信息出错");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("线程出错");
            e.printStackTrace();
        }
    }
}
