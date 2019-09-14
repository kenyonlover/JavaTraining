package com.test.gui.JMenu;

import javax.swing.*;

/**
 * 消息对话框示例
 */
public class JDialogTest_2 {
    public static void main(String[] args) {
        String str = JOptionPane.showInputDialog(null, "1 + 2 = ?");
        if (str.equals("3")){
            JOptionPane.showMessageDialog(null,"回答正确");
        } else {
            JOptionPane.showMessageDialog(null,"回答错误");
        }
        JOptionPane.showConfirmDialog(null,"测试完毕");
        System.exit(0);
    }
}
