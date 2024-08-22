package com.yy.cookie.control;

import com.yy.cookie.entry.User;
import com.yy.cookie.service.UserService;
import com.yy.cookie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookiePrjServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        UserService userService = new UserServiceImpl();
        // 获取cookie对象
        Cookie[] cookies = req.getCookies();
        // 如果cookie为空，跳转到登录页面，否则进行相关处理
        if (cookies == null)
            req.getRequestDispatcher("cookieLogin").forward(req, resp);
        else {
            String value = "";
            User u = null;
            for (Cookie c : cookies) {
                String key = c.getName();
                if (key.equals("uid")) {
                    value = c.getValue();
                    u = userService.getUserById(Integer.parseInt(value));
                }
            }
            if (u != null) {
                resp.sendRedirect("cookieHello");
            } else
                resp.sendRedirect("cookiePage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
