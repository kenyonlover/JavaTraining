package com.test.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CardTest extends JFrame implements ActionListener {

    JButton[] btn = new JButton[5];
    CardLayout card = new CardLayout();
    Panel p = new Panel();
    CardTest(){
        setSize(300,200);
        setVisible(true);
        setTitle("卡片式布局");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(p);
        p.setLayout(card);
        for (int i=1; i<=4; i++){
            btn[i] = new JButton("Button" + i);
            p.add(btn[i],"卡片标识"+ i);
            btn[i].addActionListener(this);
        }
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.next(p);
    }
}

public class CardLayoutTest {
    public static void main(String[] args) {
        new CardTest();
    }
}
