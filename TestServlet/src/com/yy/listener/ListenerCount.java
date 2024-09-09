package com.yy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 网站统计在线人数
 */
public class ListenerCount implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("context 初始化。。。");
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("count",0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context 被销毁。。。");

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session 创建");
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        int count = (int) context.getAttribute("count");
        context.setAttribute("count",count+1);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        int count = (int) context.getAttribute("count");
        context.setAttribute("count",count-1);
    }
}
