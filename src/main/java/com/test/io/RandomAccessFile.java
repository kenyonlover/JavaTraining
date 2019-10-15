package com.test.io;

import java.io.IOException;

/**
 * 用随机存取文件流读写文件
 * writeBytes(String s)方法为项文件写入一个字符串。若文件存在，则用字符串s覆盖原有的内容，若文件不存在，则新建一个文件，并写入新的内容
 */
public class RandomAccessFile {
    public static void main(String[] args) {
        try {
            java.io.RandomAccessFile f= new java.io.RandomAccessFile("testRAF.txt","rw");
            f.writeBytes("zhang si ming");
            f.close();
        }catch (IOException e){}
    }
}
