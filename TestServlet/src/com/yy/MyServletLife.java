package com.yy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet 生命周期：从第一次接受请求时创建对象，到 服务器关闭后销毁
 */
public class MyServletLife extends HttpServlet {
    /**
     * 完成servlet对象的初始化工作
     * 在servlet接受第一次请求的时间创建对象
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init 初始化完成。。。");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("servlet的生命周期。。。");
        System.out.println("life ...");
    }

    /**
     * 服务器关闭之后才销毁
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
