package com.yy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 处理中文乱码
 * get请求：
 * 1.获取字符串后，使用new String(name.getBytes("iso-8859-1","utf-8"))
 * 2.设置req的编码格式，同时在server.xml中设置 useBodyEncodingForURI=“true"的属性(useBodyEncodingForURI表示是否启用 req.setCharacterEncoding )
 * 3.在server.xml中设置 URIEncoding=”utf-8"
 *
 * post请求：
 * 1.req.setCharacterEncoding("utf-8");
 *
 * response响应编码：
 *  1.resp.setCharacterEncoding
 *
 */
public class CharsetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get请求...");
        String name = req.getParameter("name");
        System.out.println("1:"+new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        // 2.设置请求的编码格式
        req.setCharacterEncoding("utf-8");
        System.out.println(name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post请求。。。");
        String name = req.getParameter("name");
        req.setCharacterEncoding("utf-8");
        System.out.println(name);
//        resp.setCharacterEncoding("utf-8");   // 无效
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().write("欢迎来到web世界！");
    }
}
