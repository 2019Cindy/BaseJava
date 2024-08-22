package com.yy.loginPrj.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用于获取登录界面的请求
 */
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接受到客户端请求，返回响应界面");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        String res = req.getAttribute("res")==null?"": ((String) req.getAttribute("res"));
        // 获取响应的输出流对象
        PrintWriter writer = resp.getWriter();

        writer.write("<html>");
        writer.write("<head>");
        writer.write("</head>");
        writer.write("<body>");

        writer.write("<font color='red' font-size='12px'>"+res+"</font>");
        writer.write("<form action='login' method='get'>");
        writer.write("用户名：<input type='text' name='username'><br>");
        writer.write("密码：<input type='password' name='pwd'><br>");
        writer.write("<input type='submit' value='提交'>");
        writer.write("</form>");

        writer.write("</body>");
        writer.write("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
