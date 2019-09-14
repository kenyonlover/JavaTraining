package com.test.gui.JMenu;

import javax.swing.*;
import java.awt.*;

/**
 * 颜色选择对话框示例
 */
public class JDialogTest_4 {
    public static void main(String[] args) {
        Color color = JColorChooser.showDialog(null, "", null);
        JOptionPane.showMessageDialog(null,color);
    }
}
