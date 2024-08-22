package com.yy.loginPrj.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get方法。。。");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("username");
        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("</head>");
        out.write("<body>");
        out.write("<h2>" + "登录成功，欢迎 " + name + " 来到javaWeb世界！");
        out.write("</h2>");
        out.write("</body>");
        out.write("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post方法。。。");
        this.doGet(req, resp);
    }
}
