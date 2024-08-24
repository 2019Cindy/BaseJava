package com.yy.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 作用：解决不同用户的数据共享问题
 * 特点：
 *  1.由服务器创建
 *  2.所有用户共享一个servletContext对象
 *  3.所有的servlet都可以访问到同一个servletContext对象中的属性
 *  4.每一个web项目对应的是一个servletContext
 * 用法：
 *  1.获取servletContext对象
 *  2.向servletContext对象中设置属性值
 *  3.获取web.xml中的参数值
 *  4.获取文件的绝对路径
 *
 */
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get方法。。。");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取servletContext对象，有多种方式
        ServletContext context = req.getServletContext();
        ServletContext context1 = this.getServletConfig().getServletContext();
        ServletContext context2 = this.getServletContext();
        ServletContext context3 = req.getSession().getServletContext();
        System.out.println(context == context1);
        System.out.println(context == context2);
        System.out.println(context == context3);

        // 设置属性值
        context.setAttribute("res","111");

        // 获取web.xml中的参数值
        String addr = context.getInitParameter("addr");
        System.out.println(addr);
        // 多个属性的名字
        Enumeration<String> initParameterNames = context.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String s = initParameterNames.nextElement();
            System.out.println("names:" + s);
        }
        // 获取某个文件的绝对路径
        String path = context.getRealPath("web.xml");
        System.out.println("path:" + path);
        // 获取web项目的上下文路径，即配置tomcat的虚拟路径名称
        String contextPath = context.getContextPath();
        System.out.println("contextPath:"+contextPath);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post方法。。。");
        this.doGet(req, resp);
    }
}
