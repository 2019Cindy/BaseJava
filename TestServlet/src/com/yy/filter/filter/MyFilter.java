package com.yy.filter.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器：完成请求的拦截及资源的同意管理
 * 使用方法：
 *      1.实现filter接口，重写其中的方法
 *          init：初始化功能,tomcat启动的时候执行一次
 *          doFilter：进行处理，每次发送请求都会执行
 *          destroy：销毁，tomcat关闭
 *      2.filterChain:过滤器链，在项目中可以定义多个过滤器，开始执行的时候，根据用户的请求将符合规则的过滤器依次执行
 *          在web.xml文件中，可以指定过滤器过滤的请求，/*匹配所有，/*.do匹配所有后缀为do的请求
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter...");
        // 添加此语句后才会调用到对应的servlet
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter逻辑处理完成...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
