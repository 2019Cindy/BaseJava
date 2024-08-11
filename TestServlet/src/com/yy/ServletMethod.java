package com.yy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet 中可以有service方法，用于接受get 或 post 请求
 *  如果service方法和doGet、doPost同时存在，默认会调用service方法，
 *      如果service方法中调用了super.service()方法，会根据请求的方式去指定doGet 或 doPost方法
 * doGet 方法：接受get请求
 * doPost 方法：接受post请求
 * 小结：在编写servlet类的时候，不需要重写service方法，只需要重写doGet 和 doPost方法，用于处理get 或 post 请求
 */
public class ServletMethod extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service Method...");
        super.service(req,resp);
    }
}
