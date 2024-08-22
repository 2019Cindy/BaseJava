package com.yy.cookie.control;

import com.yy.cookie.entry.User;
import com.yy.cookie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// control  调用 service，service 调用 dao
public class LoginServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        // 获取请求的数据
        String usrename = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        User user = new User(usrename, pwd);
        // 调用service进行逻辑处理
        User u = userService.checkUser(user);
        System.out.println(u);
        if(u==null){
            // 请求servlet的时候，写相对路径，同时后续不需要逻辑代码的处理
            /**
             * 不同的servlet之间实现数据共享：
             *  req.setAttribute() 和 req.getAttribute()
             */
            req.setAttribute("res","用户名或密码错误！");
            /**
             *  请求转发：
             *  1.客户端值发送一次请求
             *  2.浏览器的地址栏没有发生变化
             *  3.请求过程中只有一个req和resp
             *  4.几个servlet共享一个req和resp
             */
            req.getRequestDispatcher("cookiePage").forward(req,resp);
            // 转发后，后续不再处理相关逻辑
            return;
        }else{
            /**
             * 重定向：
             * 1.浏览器发送两次请求
             * 2.浏览器的地址发生变化
             * 3.请求过程产生两个req对象和两个resp对象
             * 4.两个servlet不能共享同一个req和resp
             */
            // 设置cookie
            Cookie cookie = new Cookie("uid", String.valueOf(u.getId()));
            cookie.setMaxAge(7 * 24 * 3600);
            resp.addCookie(cookie);

            resp.sendRedirect("cookieHello");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
