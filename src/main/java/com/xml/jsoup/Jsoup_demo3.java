package com.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 通过URL得到html或者xml文件
 */
public class Jsoup_demo3 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://github.com/kenyonlover/JavaTraining");
        Document document = Jsoup.parse(url, 10000);
        System.out.println("document = [" + document + "]");
    }

}
