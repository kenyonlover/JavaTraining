package com.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * servlet的方法
 */
@WebServlet(urlPatterns = "/servlet3")
public class Servlet3 implements Servlet {
    /**
     * 初始化方法
     * 在servlet被创建时执行，只会执行一次
    * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig对象:Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 在每一次servlet被访问时执行，执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet 3.0 service ...");
    }

    /**
     * 获取servlet的一些信息：版本，作者
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时执行，只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
