package com.test.gui.JTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * 应用TreeNode构造树
 */
public class JTreeTest_2_TreeNode {
    public static void main(String[] args) {
        new MyTree("利用TreeNode构造树");
    }
}

class MyTree extends JFrame{
    MyTree(String s){
        super(s);
        Container con = getContentPane();//定义JFrame窗体容器
        //定义节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("c:\\");
        DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("备份资料");
        DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("Java学习");
        DefaultMutableTreeNode t1_1 = new DefaultMutableTreeNode("思维论坛精华帖子");
        DefaultMutableTreeNode t1_2 = new DefaultMutableTreeNode("来往邮件");
        DefaultMutableTreeNode t2_1 = new DefaultMutableTreeNode("视频教程");
        DefaultMutableTreeNode t2_2 = new DefaultMutableTreeNode("Java3D");
        //创建根节点为root的树
        JTree tree = new JTree(root);
        //定义t1,t2为root的子节点
        root.add(t1);
        root.add(t2);
        //定义t1_1,t1_2为t1的子节点
        t1.add(t1_1);
        t1.add(t1_2);
        //定义t2_1,t2_2为t2的子节点
        t2.add(t2_1);
        t2.add(t2_2);
        //带滚动条的面板（树放置其中）
        JScrollPane scrollPane = new JScrollPane(tree);
        con.add(scrollPane);
        setSize(300,200);
        setVisible(true);
        validate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}