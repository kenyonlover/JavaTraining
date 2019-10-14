package com.test.io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 字符文件流读写文本文件
 */
public class FileReaderAndFileWriter {
    public static void main(String[] args) {
        new Win();
    }
}

class Win extends JFrame implements ActionListener {

    FileReader r_file;
    FileWriter w_file;
    BufferedReader buf_reader;
    BufferedWriter buf_writer;
    JTextArea txt;
    JButton btn1, btn2;
    JPanel p;

    Win() {
        setSize(200, 200);
        setVisible(true);
        txt = new JTextArea(10, 10);
        btn1 = new JButton("Read");
        btn2 = new JButton("Write");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        p = new JPanel();
        add(txt, "Center");
        add(p, "South");
        p.setLayout(new FlowLayout());
        p.add(btn1);
        p.add(btn2);
        validate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            readFile();
        }
        if (e.getSource() == btn2) {
            writeFile();
        }
    }

    /**
     * 读取文件
     */
    private void readFile() {
        String s;
        try {
            File f = new File("D:/GitRepository/JavaTraining", "文件读取.txt");
            r_file = new FileReader(f);
            buf_reader = new BufferedReader(r_file);
            while ((s = buf_reader.readLine()) != null) {
                txt.append(s + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入文件
     */
    private void writeFile() {
        try {
         w_file = new FileWriter("文件读取_备份.txt");
         buf_writer = new BufferedWriter(w_file);
         String str = txt.getText();
         buf_writer.write(str,0,str.length());
         buf_writer.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}