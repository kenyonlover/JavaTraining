package com.test.io;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节文件输出流写入文件
 *
 * 示例：复制图像文件s1.jpg，并更名为s1_1.jpg
 */
public class FileOutputStream_2 {
    public static void main(String[] args) {
        new FileRW();
    }
}

class FileRW{
    int bytes;
    byte[] buffer = new byte[65560];
    FileInputStream fileInput;
    FileOutputStream fileOutput;

    FileRW(){
        takeimg();
        loadimg();
        JOptionPane.showMessageDialog(null,"文件复制并更名成功！\n文件大小为："+bytes);
        System.exit(0);
    }

    /**
     *将字节数组中的数据写入到文件s1_1,jpg中
     */
    private void loadimg() {
        try {
            fileOutput = new FileOutputStream("s1_1.jpg");
            fileOutput.write(buffer);
        }catch (IOException e){

        }
    }

    /**
     * 将图像文件s1.jpg数据读取到字节数组中
     */
    private void takeimg() {
        try {
            File file = new File("D:\\GitRepository\\JavaTraining\\s1.jpg");
            fileInput = new FileInputStream(file);
            bytes = fileInput.read(buffer);
        }catch (IOException e){

        }
    }
}