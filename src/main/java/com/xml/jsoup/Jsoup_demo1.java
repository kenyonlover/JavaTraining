package com.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Jsoup_demo1 {
    public static void main(String[] args) throws IOException {
        //获取document对象
        Document document = Jsoup.parse(new File("student.xml"), "utf-8");
        //获取elements元素对象
        Elements elements = document.getElementsByTag("name");
        System.out.println("elements length = [" + elements.size() + "]");
        //获取第一个element元素
        Element element = elements.get(0);
        //获取元素数据
        String name = element.text();
        System.out.println("name = [" + name + "]");
    }
}
