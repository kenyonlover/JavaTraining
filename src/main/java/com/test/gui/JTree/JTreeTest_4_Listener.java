package com.test.gui.JTree;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * 树   处理节点事件
 */
public class JTreeTest_4_Listener {
    public static void main(String[] args) {
        new TreeListenerDemo();
    }
}

class TreeListenerDemo extends JFrame implements TreeSelectionListener {
    JTree tree = null;
    JTextArea text = new JTextArea(20, 20);

    public TreeListenerDemo() {
        super("处理节点事件");
        Container con = getContentPane();
        String[][] data = {
                {"我的电脑", "磁盘C", "磁盘D", "磁盘E"},
                {"收藏夹", "思维论坛", "Java爱好者", "网上书店"},
                {"我的公文包", "公司文件", "私人文件", "往来信件"}
        };
        DefaultMutableTreeNode root;//定义根节点
        DefaultMutableTreeNode[][] treeNode;//定义节点数组
        //建立根节点对象
        root = new DefaultMutableTreeNode("桌面");
        //声明节点数组容量
        treeNode = new DefaultMutableTreeNode[4][4];
        //外循环建立父节点，内循环建立子节点
        for (int i = 0; i < data.length; i++) {
            //建立父节点treeNode
            treeNode[i][0] = new DefaultMutableTreeNode(data[i][0]);
            root.add(treeNode[i][0]);
            for (int j = 1; j < 4; j++) {
                //给节点treeNode添加多个子节点
                treeNode[i][0].add(new DefaultMutableTreeNode(data[i][j]));
            }
        }
        //创建根为root的树对象tree
        tree = new JTree(root);
        JScrollPane scrollPane = new JScrollPane(text);//创建带滚动条的面板
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, tree, scrollPane);//创建可拆分的窗体
        con.add(splitPane);
        tree.addTreeSelectionListener(this);
        setSize(500, 200);
        setVisible(true);
        validate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        if (e.getSource() == tree) {
            //定义被选中的节点
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node.isLeaf()) {
                //获取叶节点所定义的文本信息
                String str = node.toString();
                if (str.equals("磁盘C")) {
                    text.setText(str + ":\n 这里显示的C盘文件");
                } else if (str.equals("磁盘D")) {
                    text.setText(str + ":\n 这里显示的D盘文件");
                } else if (str.equals("磁盘E")) {
                    text.setText(str + ":\n 这里显示的E盘文件");
                } else if (str.equals("思维论坛")) {
                    text.setText(str + ":\n 这里显示的是思维论坛");
                } else if (str.equals("Java爱好者")) {
                    text.setText(str + ":\n 这里显示的是Java爱好者");
                } else if (str.equals("网上书店")) {
                    text.setText(str + ":\n 这里显示的是网上书店");
                } else if (str.equals("公司文件")) {
                    text.setText(str + ":\n 这里显示的是公司文件");
                } else if (str.equals("私人文件")) {
                    text.setText(str + ":\n 这里显示的是私人文件");
                } else if (str.equals("往来信件")) {
                    text.setText(str + ":\n 这里显示的是往来信件");
                }
            } else {
                text.setText(node.getUserObject().toString());
            }
        }
    }
}