package com.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * jsoup_element对象
 */
public class Jsoup_demo5 {
    public static void main(String[] args) throws IOException {
        //获取document对象
        Document document = Jsoup.parse(new File("student.xml"), "utf-8");
        //通过document对象获取所有的elements元素对象
        Elements elements = document.getElementsByTag("name");

        //通过element对象获取字标签对象
        Element student = document.getElementsByTag("student").get(0);
        Elements name = student.getElementsByTag("name");
        System.out.println("name = [" + name + "]");

        //获取student对象的属性值
        String number = student.attr("number");
        System.out.println("number = [" + number + "]");

        //获取文本内容
        String text = name.text();
        String html = name.html();
        System.out.println("text = [" + text + "]");//获取所有子标签的纯文本内容
        System.out.println("html = [" + html + "]");//获取所有子标签的标签和文本内容
    }
}
