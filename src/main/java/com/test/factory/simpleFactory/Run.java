package com.test.factory.simpleFactory;

/**
 * created by Administrator on 2019/7/29
 * describe:
 */
public class Run {
    public static void main(String[] args) {
        INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_GK);
        noodles.desc();
    }
}
