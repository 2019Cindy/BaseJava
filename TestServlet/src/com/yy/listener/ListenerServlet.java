package com.yy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
        System.out.println("listener....");
        req.setAttribute("hhh","aaa");
        req.setAttribute("狗刚","牛马");
        req.removeAttribute("狗刚");

        ServletContext context = this.getServletContext();
        context.setAttribute("123","abc");
        context.setAttribute("aaa","bbb");
        context.removeAttribute("aaa");

        HttpSession session = req.getSession();
        session.setAttribute("狗","牛马");
        session.removeAttribute("狗");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
