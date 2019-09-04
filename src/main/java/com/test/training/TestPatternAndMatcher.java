package com.test.training;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式
 */
public class TestPatternAndMatcher {
    public static void main(String args[]){
        Pattern pattern1,pattern2,pattern3,pattern4;
        Matcher matcher1,matcher2,matcher3,matcher4;

        // 查找以Java开头，任意结尾的字符串
        pattern1 = Pattern.compile("^Java.*");
        matcher1 = pattern1.matcher("Java是一种程序语言");
        boolean b = matcher1.matches();
        //当条件满足时，将返回true，否则返回false
        System.out.println("查找以Java开头的字符串：" + b);

        //以多条件分割字符串
        pattern2 = Pattern.compile("[, |]");
        String[] strs = pattern2.split("Java Hello World  Java,Hello,,World|Sun");
        System.out.println("分割字符串：");
        for (int i = 0 ; i < strs.length; i ++){
            System.out.println(strs[i]);
        }

        //文字替换（全部）
        pattern3 = Pattern.compile("正则");
        matcher3 = pattern3.matcher("正则 Hello World,正则表达式 Hello World");
        //替换第一个符合正则的数据
        System.out.println("文字替换（全部）："+matcher3.replaceAll("Java"));

        //文字替换（置换字符）
        pattern4 = Pattern.compile("表达式");
        matcher4 = pattern4.matcher("表达式 Hello World,表达式 Hello World");
        StringBuffer sbr = new StringBuffer();
        while (matcher4.find()){
            matcher4.appendReplacement(sbr, "Java");
        }
        matcher4.appendTail(sbr);
        System.out.println("文字替换（置换字符）：" + sbr.toString());
    }
}
