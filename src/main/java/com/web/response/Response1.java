package com.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response1")
public class Response1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("response1...");
        //重定向
        /*response.setStatus(302);
        response.setHeader("location","/JavaTraining/response2");*/
        //简单重定向
        String contextPath = request.getContextPath();//动态获取虚拟目录
        response.sendRedirect(contextPath+"/response2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
