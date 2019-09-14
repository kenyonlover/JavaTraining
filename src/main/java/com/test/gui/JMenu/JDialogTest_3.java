package com.test.gui.JMenu;

import javax.swing.*;

/**
 * 文件选择对话框示例
 */
public class JDialogTest_3 {
    public static void main(String[] args) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(null);
        String string = jFileChooser.getSelectedFile().toString();
        JOptionPane.showMessageDialog(null,string);
    }
}
