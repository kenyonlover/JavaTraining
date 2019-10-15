package com.test.io;

import javax.media.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * 多媒体包jmf的应用
 */
public class Media_1 {
    public static void main(String[] args) {
        new MediaPlay();
    }
}

class MediaPlay extends JFrame implements ControllerListener {

    String mediaFile;
    Component comp1,comp2;
    Player player;
    MediaPlay(){
        super("多媒体播放器");
        setVisible(true);
        setBounds(300,100,350,300);
        mediaFile = "file:///E:\\学习资料\\黑马程序员_Springmvc+Mybatis由浅入深全套视频教程video\\mybatis\\day01\\01mybatis第一天课程安排.mp4";//音频或视频文件
        validate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        play();
    }

    private void play() {
        String str = new String(mediaFile);
        MediaLocator mrl = new MediaLocator(str);
        try {
            player = Manager.createPlayer(mrl);
            player.addControllerListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoPlayerException e) {
            e.printStackTrace();
        }
        if (player!=null){
            player.prefetch();
        }
    }

    @Override
    public void controllerUpdate(ControllerEvent controllerEvent) {
        if (controllerEvent instanceof RealizeCompleteEvent){
            if ((comp1 = player.getVisualComponent())!=null){
                add("Center",comp1);
            }
            if ((comp2 = player.getControlPanelComponent())!=null){
                add("South",comp2);
            }
            validate();
        }else if(controllerEvent instanceof PrefetchCompleteEvent){
            player.start();
        }
    }
}