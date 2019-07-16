package com.test.training;

/**
 * created by Administrator on 2019/7/16
 * describe:
 */
public class TestBreak {
    public static void main(String[] args) {
        ok :
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < 5; j++) {
                System.out.println("j = " + j);
                if (i ==2 && j == 2) {
                    break ok;
                }
            }
        }
        System.out.println("结束啦");
    }
}
