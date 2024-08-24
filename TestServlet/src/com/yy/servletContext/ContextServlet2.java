package com.yy.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get方法。。。");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        ServletContext context = req.getServletContext();
        String res = (String) context.getAttribute("res");
        System.out.println("res:" + res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post方法。。。");
        this.doGet(req, resp);
    }
}
