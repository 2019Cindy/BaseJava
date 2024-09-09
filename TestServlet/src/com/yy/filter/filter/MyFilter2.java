package com.yy.filter.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter2 init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter2...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("doFilter2 执行完毕...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy2...");
    }
}
