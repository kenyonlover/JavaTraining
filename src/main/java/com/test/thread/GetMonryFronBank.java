package com.test.thread;

/**
 * 调用线程的主类
 */
public class GetMonryFronBank {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        c1.start();
        c2.start();
    }
}

/**
 * 银行账户
 * 使用 synchronized 同步线程
 */
class Mbank{
    private static int sum = 200;
    public synchronized static  void take(int k){
        int temp = sum;
        temp-=k;
        try {
            Thread.sleep((int)(1000*Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = temp;
        System.out.println("sum = [" + sum + "]");
    }
}

/**
 * 用户取款的线程类
 */
class Customer extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            Mbank.take(100);
        }
    }
}