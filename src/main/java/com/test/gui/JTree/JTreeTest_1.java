package com.test.gui.JTree;

import javax.swing.*;

/**
 * 简单树结构测试
 */
public class JTreeTest_1 {
    public static void main(String[] args) {
        new TreeDemo();
    }
}

class TreeDemo extends JFrame{
    public TreeDemo(){
        setSize(400,300);
        setTitle("演示如何使用JTree");
        show();
        JScrollPane jScrollPane = new JScrollPane();
        getContentPane().add(jScrollPane);
        //创建系统默认的树状对象
        JTree jTree = new JTree();
        //在面板上添加树状结构
        jScrollPane.getViewport().add(jTree,null);
        validate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}