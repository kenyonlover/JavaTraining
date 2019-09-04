package com.test.training;

import java.util.StringTokenizer;

/**
 * 测试字符分析器TeatStringTokenizer
 */
public class TeatStringTokenizer {
    public static void main(String args[]){
        String s = "this is a string";
        StringTokenizer st = new StringTokenizer(s, " ,");
        int number = st.countTokens();
        while (st.hasMoreTokens()){
            String str = st.nextToken();
            System.out.println(str);
        }
        System.out.println("s 共有单词："+number+"个");
    }
}
