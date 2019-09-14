package com.test.gui.JComponent;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * 更多格式的表格测试
 */
public class JTableTest_2 {
    public static void main(String[] args) {
        TableDemo tableDemo = new TableDemo();
        tableDemo.pack();
        tableDemo.setVisible(true);
    }
}

class TabelDemo extends JFrame {
    public TabelDemo() {
        //首先调用父类JFrame的构造方法生成一个窗口
        super("员工档案表");
        //myModel存放表格的数据
        MyTabelModel myModel = new MyTabelModel();
        //表格对象table的数据来源是myModel对象
        JTable table = new JTable(myModel);
        //表格的显示尺寸
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //产生一个带滚动条的面板
        JScrollPane scrollPane = new JScrollPane(table);
        //将带滚动条的面板加入窗口中
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

/**
 * 把要显示在表格中的数据存入字符串数组和Object数组中
 */
class MyTabelModel extends AbstractTableModel {

    private boolean DEBUG = true;
    //表格中第一行所要显示的内容存放在字符串数组columnNames中
    final String[] columnNames = {"姓名", "职务", "电话", "月薪", "婚否"};
    //表格中各行的内容保存在二维数组data中
    final Object[][] data = {
            {"李强", "经理", "790231", new Integer(5000), new Boolean(true)},
            {"吴虹", "秘书", "785321", new Integer(3500), new Boolean(true)},
            {"陈卫东", "主管", "498732", new Integer(4500), new Boolean(false)},
            {"欧阳健", "保安", "796879", new Integer(2000), new Boolean(true)},
            {"石乐乐", "销售", "541298", new Integer(4000), new Boolean(false)}
    };

    /**
     * 下面是重写AbstractTableModel中的方法，其主要用途是被JTable对象调用，
     * 以便在表格中正确的显示出来。
     * 要注意根据采用的数据类型加以恰当的实现
     */

    /**
     * 获得行的数目
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return data.length;
    }

    /**
     * 获得列的数目
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * 获得某行某列的数据，而数据保存在对象数组data中
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    /**
     * 获得某列的名字，而目前各列的名字保存在字符串数组columnNames中
     *
     * @param columnIndex
     * @return
     */
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    /**
     * 判断每个单元格的类型
     *
     * @param columnIndex
     * @return
     */
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    /**
     * 将表格声明为可编辑的
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex < 2) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (DEBUG) {
            System.out.println(" setting value at rowIndex [" + rowIndex + "], columnIndex [" + columnIndex + "] to value [" + value + "] (an instance of " + value.getClass() + ")");
            if (data[0][0] instanceof Integer && !(value instanceof Integer)) {
                try {
                    data[rowIndex][columnIndex] = new Integer(value.toString());
                    fireTableCellUpdated(rowIndex, columnIndex);
                } catch (NumberFormatException e) {
                    TableDemo tableDemo = new TableDemo();
                    JOptionPane.showMessageDialog(tableDemo, "The \"" + getColumnName(columnIndex) + "\" column accepts only integer values.");
                }
            } else {
                data[rowIndex][columnIndex] = value;
                fireTableCellUpdated(rowIndex, columnIndex);
            }
            if (DEBUG) {
                System.out.println("new value if data:");
                printDebugData();
            }
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();
        for (int i = 0; i < numRows; i++) {
            System.out.print(" row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("------------------------------------");
    }
}
