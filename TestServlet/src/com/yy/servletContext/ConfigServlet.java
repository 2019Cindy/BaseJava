package com.yy.servletContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * servletConfig 对象
 *  作用：方便每一个servlet获取自己单独的属性配置
 *  特点：
 *      1.每一个servlet单独拥有一个servletConfig对象
 *  使用：
 *
 */
public class ConfigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取对象
        ServletConfig config = this.getServletConfig();
        // 获取值
        String china = config.getInitParameter("china");
        System.out.println("china:" + china);
        // 获取所有的key
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String key = initParameterNames.nextElement();
            String value = config.getInitParameter(key);
            System.out.println("key:" + key + ", value:" + value);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
