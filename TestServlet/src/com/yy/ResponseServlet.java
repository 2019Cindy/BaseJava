package com.yy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * response 表示服务器端返回数据的响应对象
 * 响应头：
 * 响应行：
 * 响应体：
 */
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法");
        System.out.println("=============设置响应头================");
        // 设置响应头，按照key-value的键值对方式设置
        resp.setHeader("hhhh","aaaa");
        // 如果存在相同的key值，setHeader会将值覆盖，addHeader不会进行覆盖
        resp.setHeader("hhhh","wawawa");
        resp.addHeader("123","345");
        resp.addHeader("123","yyyy");

        System.out.println("================响应体=================");
        // 服务器端返回的数据按照一定的格式进行渲染显示
//        resp.setHeader("Content-type","text/html");
        // 设置响应状态码
//        resp.sendError(404,"not found");
        resp.getWriter().write("<b>so easy</b>,hhh");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法");
        this.doGet(req,resp);
    }
}
