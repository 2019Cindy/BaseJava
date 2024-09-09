package com.yy.listener;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器：主要监听对象的创建和销毁，属性的改变
 * 主要用于监听三种作用域：
 *      servletContext（application）  session  request
 *      1.request：
 *          ServletRequestListener：监听request对象的创建和销毁
 *          ServletRequestAttributeListener：监听request作用域属性的添加、删除、修改
 *      2.servletContext：
 *          ServletContextListener：启动tomcat对象的时候创建和销毁
 *          ServletContextAttributeListener：
 */
public class MyListener implements ServletRequestListener, ServletRequestAttributeListener, ServletContextListener,ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("req 对象被销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("req 对象初始化");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("req 属性添加成功");
        System.out.println(servletRequestAttributeEvent.getName());
        System.out.println(servletRequestAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("req 属性删除成功");
        System.out.println(servletRequestAttributeEvent.getName());
        System.out.println(servletRequestAttributeEvent.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("req 属性替换成功");
        System.out.println(servletRequestAttributeEvent.getName());
        System.out.println(servletRequestAttributeEvent.getValue());
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("context 对象初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context 对象被销毁");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("context 添加属性："+servletContextAttributeEvent.getName()+":"+servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("context 删除属性："+servletContextAttributeEvent.getName()+":"+servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("context 修改属性："+servletContextAttributeEvent.getName()+":"+servletContextAttributeEvent.getValue());
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session 对象创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session 对象被销毁");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session 属性添加，"+httpSessionBindingEvent.getName()+":"+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session 属性删除，"+httpSessionBindingEvent.getName()+":"+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session 属性修改，"+httpSessionBindingEvent.getName()+":"+httpSessionBindingEvent.getValue());
    }
}
