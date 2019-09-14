package com.test.gui.JTree;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * 利用hash表构造树
 */
public class JTreeTest_3_HashTable {
    public static void main(String[] args) {
        new TreesDemo();
    }
}

class TreesDemo {
    public TreesDemo() {
        JFrame f = new JFrame("哈希表定义树结构演示");
        Hashtable hashtable1 = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        String[] s1 = {"思维论坛", "Java爱好者", "网上书店"};
        String[] s2 = {"公司文件", "私人文件", "往来信件"};
        String[] s3 = {"磁盘C", "磁盘D", "磁盘E"};
        hashtable1.put("桌面", hashtable2);
        hashtable2.put("收藏夹", s1);
        hashtable2.put("我的公文包", s2);
        hashtable2.put("我的电脑", s3);
        //树进行初始化，其数据来源是root对象
        JTree tree = new JTree(hashtable1);
        JScrollPane scrollPane = new JScrollPane(tree);
        Container con = f.getContentPane();
        con.add(scrollPane);
        f.setSize(200,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
