package com.web.download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download1")
public class Download1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        //获取真实路径
        String path = this.getServletContext().getRealPath("/img/" + filename);
        //用字节流关联
        FileInputStream fis = new FileInputStream(path);

        //设置response的响应头
        String mimeType = this.getServletContext().getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);

        //解决中文乱码问题
        String agent = request.getHeader("user-agent");//获取user-agent请求头
        filename = DownLoadUtils.getFileName(agent, filename);//使用工具类方法编码文件名即可

        response.setHeader("content-disposition","attachment;filename="+filename);//通知浏览器以附件形式打开

        //将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
