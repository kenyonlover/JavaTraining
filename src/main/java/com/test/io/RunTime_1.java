package com.test.io;

import java.io.IOException;

/**
 * 调用Windows系统自带的计算器
 */
public class RunTime_1 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("C:/windows/system32/calc.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
