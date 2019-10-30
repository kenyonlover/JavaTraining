package com.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 通过字符串得到html或者xml文件
 */
public class Jsoup_demo2 {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<students>\n" +
                "\n" +
                "    <student number=\"heima_0001\">\n" +
                "        <name>tom</name>\n" +
                "        <age>18</age>\n" +
                "        <sex>male</sex>\n" +
                "    </student>\n" +
                "\n" +
                "    <student number=\"heima_0002\">\n" +
                "        <name>jack</name>\n" +
                "        <age>18</age>\n" +
                "        <sex>female</sex>\n" +
                "    </student>\n" +
                "\n" +
                "</students>";
        Document document = Jsoup.parse(xml);
        System.out.println("document = [" + document + "]");
    }
}
