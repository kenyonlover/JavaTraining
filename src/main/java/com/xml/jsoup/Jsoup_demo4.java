package com.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * jsoup_document_element对象
 */
public class Jsoup_demo4 {
    public static void main(String[] args) throws IOException {
        //获取document对象
        Document document = Jsoup.parse(new File("student.xml"), "utf-8");
        //获取元素对象
        //获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println("elements = [" + elements + "]");
        System.out.println("===========================================================");

        //获取属性名为id的元素对象
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println("elements1 = [" + elements1 + "]");
        System.out.println("===========================================================");

        //获取number属性值为heima_0001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println("elements2 = [" + elements2 + "]");
        System.out.println("===========================================================");

        //通过id对象获取element对象
        Element element = document.getElementById("name1");
        System.out.println("element = [" + element + "]");
        System.out.println("===========================================================");
    }
}
