package com.yy.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie 用来处理客户端发送不同请求的时候，如何使用相同的参数学习
 * cookie的使用：常见cookie对象，将cookie设置到resp对象中,设置cookie的参数（生命周期，路径），获取cookie对象
 * 特点：
 *      1.cookie是保存在浏览器端的数据
 *      2.分类：临时cookie：默认是存储在内存中，当浏览器关闭后，cookie自动失效
 *          持久化cookie：保存在浏览器的某个存储路径，当时间过期后才会失效
 *      3.每一个cookie对象中，保存一个key-value键值对数据，想要存储多个k-v数据，需要创建多个cookie对象
 */
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get方法。。。");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 常见cookie对象
        Cookie cookie = new Cookie("001", "beijing");
        // 设置cookie的生命周期，单位为秒
        cookie.setMaxAge(3 * 24 * 3600);
        Cookie cookie2 = new Cookie("002", "wuhan");
        Cookie cookie3 = new Cookie("001", "shanghai");
        // 给cookie设置固定的路径值,只有请求对应的路径时才将cookie设值进去
        cookie2.setPath("/cookie/abc");
        // 将cookie设置到resp对象中
        resp.addCookie(cookie);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        resp.getWriter().write("学习cookie！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post方法。。。");
        this.doGet(req, resp);
    }
}
