package com.test.training;

/**
 * created by Administrator on 2019/7/18
 * describe: java基础
 */
public class TestJavaBase {
    public static void main(String[] args) {
        new TestJavaBase().testHash();
    }

    /**
     * 测试hash
     */
    void testHash() {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("a.hash = " + a.hashCode());
        System.out.println("b.hash = " + b.hashCode());
        System.out.println("c.hash = " + c.hashCode());
        System.out.println("a == b => " + a == b);
        System.out.println("a == c => " + a == c);
        System.out.println("c == b => " + c == b);
        System.out.println("a.equals(b) => " + a.equals(b));
        System.out.println("a.equals(c) => " + a.equals(c));
        System.out.println("c.equals(b) => " + c.equals(b));
    }
}
