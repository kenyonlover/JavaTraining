package com.test.thread;

import javax.swing.*;
import java.awt.*;

/**
 * 模拟车辆过交通路口
 */
public class CarByCrossing {
    public static void main(String[] args) {
        new Road();
    }
}

class Road extends JFrame{
    ICar LRcar,TBcar;//声明小车对象
    TrafficCop tCop;//声明交通警察（线程同步）对象

    Road(){
        setSize(400,400);
        setVisible(true);
        setTitle("线程同步示例");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tCop = new TrafficCop();//创建交通警察（线程同步）对象
        LRcar = new ICar(tCop,ICar.leftToRight,16);//创建从左往右行驶的小车
        TBcar = new ICar(tCop,ICar.topToButton,17);//创建从上往下行驶的小车
        start();
    }

    private void start() {
        LRcar.start();//从左往右行驶
        TBcar.start();//从上往下行驶
        while (true){
            //刷新画面
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public void paint(Graphics g){
        super.paint(g);//调用父类的构造方法paint()
        Color saveColor = g.getColor();
        g.setColor(Color.black);
        g.fillRect(0,180,400,40);//绘制横向通道
        g.fillRect(180,0,40,400);//绘制纵向通道
        LRcar.drawCar(g);//绘制小车
        TBcar.drawCar(g);//绘制小车
    }
}

class ICar extends Thread{
    public int lastPos = -1;//小车最后位置
    public int carPos = 0;//小车当前位置
    public int speed =10;//初始化小车速度
    public int direction =1;//初始化小车的行驶方向
    public TrafficCop tCop;//声明交通净警察对象（线程同步）
    public final static int leftToRight = 1;
    public final static int topToButton = 2;

    public ICar(TrafficCop tCop,int direction,int speed){
        this.tCop = tCop;
        this.direction=direction;
        this.speed=speed;
    }

    @Override
    public void run() {
        while (true){
            tCop.checkAndGo(carPos,speed);//线程同步
            carPos+=speed;//小车行进，每次增加speed
            if (carPos>=400){//若到达边界，则重新开始
                carPos=0;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 绘制小车
     * @param g
     */
    public void drawCar(Graphics g){
        if (direction == ICar.leftToRight){//方向判断。从西往东（从左往右）行驶的小车
            //绘制车轮
            g.setColor(Color.gray);
            g.fillOval(2+carPos,185,10,10);
            g.fillOval(26+carPos,185,10,10);
            g.fillOval(2+carPos,205,10,10);
            g.fillOval(26+carPos,205,10,10);
            //绘制车身
            g.setColor(Color.green);
            g.fillOval(0+carPos,190,40,20);
            lastPos=carPos;//获取小车当前位置
        } else {//绘制从北往南（从上往下）行驶的小车
            g.setColor(Color.gray);
            g.fillOval(185,2+carPos,10,10);
            g.fillOval(185,26+carPos,10,10);
            g.fillOval(205,2+carPos,10,10);
            g.fillOval(205,26+carPos,10,10);
            //绘制车身
            g.setColor(Color.yellow);
            g.fillOval(190,0+carPos,20,40);
            lastPos=carPos;//获取小车当前位置
        }
    }
}

/**
 * 该类用于ICar线程的控制（交通警察）
 */
class TrafficCop{
    private boolean IntersectionBusy = false;
    //定义同步化方法 checkAndGo()
    public synchronized void checkAndGo(int catPos,int speed){
        if (catPos+40<180&&catPos+40+speed>=180&&catPos+speed<=200){
            while (IntersectionBusy){
                try {
                    wait();//使线程处于等待状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            IntersectionBusy =true;
        }
        if (catPos+speed>200){
            IntersectionBusy=false;
        }
        notify();//线程退出等待状态
    }
}