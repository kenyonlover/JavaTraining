package com.test.gui.JMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 测试一个菜单程序
 */
public class JMenuTest_1 extends JFrame implements ActionListener {
    JMenuItem fileNew = new JMenuItem("新建文件");
    JMenuItem fileOpen = new JMenuItem("打开文件");
    JMenuItem fileExit = new JMenuItem("退出");
    JMenuItem editCut = new JMenuItem("剪切");
    JMenuItem editCopy = new JMenuItem("复制");
    JMenuItem editPaste = new JMenuItem("粘贴");

    public JMenuTest_1(){
        super("菜单演示程序");
        JMenu file = new JMenu("文件");
        file.add(fileNew);
        fileNew.setEnabled(false);
        file.add(fileOpen);
        fileOpen.setEnabled(false);
        file.addSeparator();//添加一条分割线
        file.add(fileExit);
        fileExit.setEnabled(true);
        JMenu edit = new JMenu("编辑");
        edit.add(editCut);
        editCut.setEnabled(false);
        edit.add(editCopy);
        editCopy.setEnabled(false);
        edit.add(editPaste);
        editPaste.setEnabled(false);
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(file);
        bar.add(edit);
        fileExit.addActionListener(this);
        setSize(250,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==fileExit)
            System.exit(0);
    }

    public static void main(String[] args) {
        new JMenuTest_1();
    }

}