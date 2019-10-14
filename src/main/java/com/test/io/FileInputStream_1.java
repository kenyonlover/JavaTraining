package com.test.io;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 字节文件输入流读取文件
 *
 * 示例：读取txt文件
 *
 * 字节流不能直接操作Unicode字符，文件中的汉字会出现乱码
 * 因此，java不提倡使用字节流读取文本文件，而建议使用字符流操作文本文件
 */
public class FileInputStream_1 {
    public static void main(String[] args) {
        byte[] buffer = new byte[2056];
        int bytes;
        String str=null;
        File file = new File("D:\\GitRepository\\JavaTraining\\文件读取.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bytes = fileInputStream.read(buffer);
            str = new String(buffer,0,bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,str);
        System.exit(0);
    }
}
