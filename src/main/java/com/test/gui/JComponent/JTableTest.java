package com.test.gui.JComponent;

import javax.swing.*;
import java.awt.*;

/**
 * JTable 表格测试
 */
public class JTableTest {
    public static void main(String[] args) {
        new TableDemo();
    }
}

class TableDemo extends JFrame{
    TableDemo(){
        super("员工档案表");
        String[] columnNames = {"姓名","职务","电话","月薪","婚否"};
        Object[][] data = {
                {"李强","经理","790231",new Integer(5000),new Boolean(true)},
                {"吴虹","秘书","785321",new Integer(3500),new Boolean(true)},
                {"陈卫东","主管","498732",new Integer(4500),new Boolean(false)},
                {"欧阳健","保安","796879",new Integer(2000),new Boolean(true)},
                {"石乐乐","销售","541298",new Integer(4000),new Boolean(false)}
        };
        JTable table = new JTable(data,columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(700,70));//定义表格尺寸
        JScrollPane scrollPane = new JScrollPane(table);//带滚动条面板
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}