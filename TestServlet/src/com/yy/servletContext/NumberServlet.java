package com.yy.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 网站计数器
 */
public class NumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        ServletContext context = this.getServletContext();
        Integer num = (Integer) context.getAttribute("num");
        if (num == null) {
            context.setAttribute("num", 1);
        } else {
            num++;
            context.setAttribute("num", num);
        }
        resp.getWriter().write("用户访问的次数为：" + context.getAttribute("num"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
