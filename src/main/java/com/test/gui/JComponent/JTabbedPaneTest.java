package com.test.gui.JComponent;

import javax.swing.*;

/**
 * JTabbedPane 卡片选项页面示例
 */
public class JTabbedPaneTest {
    public static void main(String[] args) {
        new TtpDemo();
    }
}

class TtpDemo extends JFrame{
    TtpDemo(){
        super("卡片选项页面示例");
        setSize(300,200);
        setVisible(true);
        JTabbedPane jtp = new JTabbedPane();
        ImageIcon icon1 = new ImageIcon("s1.jpg");
        ImageIcon icon2 = new ImageIcon("s2.jpg");
        ImageIcon icon3 = new ImageIcon("s3.jpg");
        jtp.addTab("城市",icon1,new CitiesPanel(),"城市名称");
        jtp.addTab("文学",icon2,new BookPanel(),"文学目录");
        jtp.addTab("网站",icon3,new NetPanel(),"精选网址");
        getContentPane().add(jtp);
        validate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class CitiesPanel extends JPanel{
    CitiesPanel(){
        JButton b1 = new JButton("北京");
        JButton b2 = new JButton("上海");
        JButton b3 = new JButton("深圳");
        JButton b4 = new JButton("厦门");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
    }
}

class BookPanel extends JPanel{
    BookPanel(){
        JCheckBox cb1 = new JCheckBox("西游记");
        JCheckBox cb2 = new JCheckBox("三国演义");
        JCheckBox cb3 = new JCheckBox("红楼梦");
        add(cb1);
        add(cb2);
        add(cb3);
    }
}

class NetPanel extends JPanel{
    NetPanel(){
        JComboBox jcb = new JComboBox();
        jcb.addItem("思维论坛");
        jcb.addItem("百度搜索");
        jcb.addItem("Java爱好者");
        add(jcb);
    }
}