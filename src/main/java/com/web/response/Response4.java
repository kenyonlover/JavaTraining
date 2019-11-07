package com.web.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务器输出字节流到浏览器
 */
@WebServlet("/response4")
public class Response4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //告诉浏览器，服务器发送的消息体的数据的编码，建议浏览器使用该编码解释
        //response.setHeader("content-type","text/html;charset=utf-8");
        //设置编码的简单形式
        response.setContentType("text/html;charset=utf-8");
        //获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //输出数据
        outputStream.write("你好啊 response".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
