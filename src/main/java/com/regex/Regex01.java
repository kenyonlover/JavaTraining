package com.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式练习
 */
public class Regex01 {
    public static void main(String[] args) {
//        group();
//        split();
//        checkTelnum();
//        checkEmail();
        checkQQ();
    }

    /**
     * 分组
     */
    public static void group() {
        Pattern pattern = Pattern.compile("([a-z]+)([0-9]+)");
        Matcher matcher = pattern.matcher("abc123***xyz789");
        while (matcher.find()) { //扫描输入的序列，查找该模式匹配的下一个子序列
            System.out.println(matcher.group());//全部分组，即([a-z]+)([0-9]+)
            System.out.println(matcher.group(1));//第1个分组，即([a-z]+)
            System.out.println(matcher.group(2));//第2个分组，即([0-9]+)
        }
    }

    /**
     * 分割
     */
    public static void split() {
        String str = "a,b,c";
        String[] arrs = str.split(",");//通过符号","分割
        System.out.println(Arrays.toString(arrs));

        String str2 = "abc123def456ghi789jkl012lmn";
        String[] arrs2 = str2.split("\\d+");//通过正则表达式分割，"\d"表示数字，"\d+"表示多个数字
        System.out.println(Arrays.toString(arrs2));
    }

    /**
     * 校验电话号码
     */
    public static void checkTelnum() {
        String phones[] = new String[]{"13900442200", "021-88889999", "88889999", "1111111111"};
        for (int i = 0; i < phones.length; i++) {
            if (isPhone(phones[i]) || isMobile(phones[i])) {
                System.out.println(phones[i] + "是符合的");
            } else {
                System.out.println(phones[i] + "是不符合的");
            }
        }
    }

    /**
     * 手机号验证
     *
     * @param str
     * @return 验证通过返回true
     * ^是正则表达式匹配字符串开始位置
     * $是正则表达式匹配字符串结束位置
     */
    public static boolean isMobile(final String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8,9][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 电话号码验证
     *
     * @param str
     * @return 验证通过返回true
     *  
     */
    public static boolean isPhone(final String str) {
        Pattern p1 = null, p2 = null;
        Matcher m = null;
        boolean b = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            b = m.matches();
        } else {
            m = p2.matcher(str);
            b = m.matches();
        }
        return b;
    }

    /**
     * 校验邮箱号
     */
    public static void checkEmail() {
        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        String mail = "id_for_yy@qq.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mail);
        if (m.matches()) {
            System.out.println(mail + "是合法的邮箱");
        } else {
            System.out.println(mail + "是不合法的邮箱");
        }
    }

    /**
     * 校验QQ号
     */
    public static void checkQQ() {
        String regex = "[1-9][0-9]{4,}";
        String qq = "13079804362";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(qq);
        if (m.matches()) {
            System.out.println(qq + "是合法的QQ");
        } else {
            System.out.println(qq + "是不合法的QQ");
        }
    }
}
