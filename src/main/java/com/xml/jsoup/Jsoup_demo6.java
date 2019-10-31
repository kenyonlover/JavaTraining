package com.xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <h3>快捷查询方式：</h3>
 * <h5>1. selector:选择器</h5>
 *      使用方法：Elements select(String cssQuery)
 *          语法：参考selector类中定义的语法
 * <h5>2. XPath:</h5>
 *      即xml路径语言，它是一种用来确认xml文档中某部分位置的语言.
 *      w3cschool可以查询到xpath语法
 */
public class Jsoup_demo6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //获取document对象
        Document document = Jsoup.parse(new File("student.xml"), "utf-8");

        /*
          使用selector
         */
        //查询name标签
        Elements elements = document.select("name");
        System.out.println("elements = [" + elements + "]");
        System.out.println("==================================================");

        //查询id值为name1的元素
        Elements elements1 = document.select("#name1");
        System.out.println("elements1 = [" + elements1 + "]");
        System.out.println("==================================================");

        //查询number='heima_0001'的student元素中的age标签
        Elements elements2 = document.select("student[number='heima_0001']");
        System.out.println("elements2 = [" + elements2 + "]");
        System.out.println("--------------------------------------------------");
        Elements elements3 = document.select("student[number='heima_0001'] > age");
        System.out.println("elements3 = [" + elements3 + "]");
        System.out.println("==================================================");



        /*
            使用XPath
         */
        //根据document创建JXDocument对象
        //查询所有student标签
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println("jxNode = [" + jxNode + "]");
            Element element = jxNode.getElement();
        }
        System.out.println("==================================================");

        //查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode2 : jxNodes2) {
            System.out.println("jxNode2 = [" + jxNode2 + "]");
            Element element = jxNode2.getElement();
        }
        System.out.println("==================================================");

        //查询所有student标签下带有id属性的name标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode3 : jxNodes3) {
            System.out.println("jxNode3 = [" + jxNode3 + "]");
            Element element = jxNode3.getElement();
        }
        System.out.println("==================================================");

        //查询所有student标签下带有id属性的name标签并且id属性值为name1
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='name1']");
        for (JXNode jxNode4 : jxNodes4) {
            System.out.println("jxNode4 = [" + jxNode4 + "]");
            Element element = jxNode4.getElement();
        }
        System.out.println("==================================================");
    }

}
