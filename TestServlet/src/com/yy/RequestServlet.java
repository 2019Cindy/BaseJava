package com.yy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * HttpServletRequest 用来存放客户端请求的参数
 * 请求行：
 * 请求头：
 * 请求体：
 */
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get请求");
        System.out.println("==================获取请求行数据===================");
        // 获取请求中的请求方式
        System.out.println("请求方式" + req.getMethod());
        StringBuffer url = req.getRequestURL();
        System.out.println("请求的完整地址：" + url);
        String uri = req.getRequestURI();
        System.out.println("请求的资源路径：" + uri);
        String scheme = req.getScheme();
        System.out.println("获取请求中的协议：" + scheme);

        System.out.println("==================获取请求头数据===================");
        // 根据key获取value的值
        String userAgent = req.getHeader("user-agent");
        System.out.println("userAgent:" + userAgent);
        // 获取请求头中所有key的枚举对象
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
//            System.out.println(headerNames.nextElement());
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            System.out.println("key:" + key + ",value:" + value);
        }

        System.out.println("===============获取用户请求数据===============");
        String name = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String fun = req.getParameter("fun");
        System.out.println("username:" + name + ",pwd:" + pwd + ",fun:" + fun);
        // 获取用户数据中的所有key
        System.out.println("获取用户数据中所有的key-value");
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            String value = req.getParameter(key);
            System.out.println("key:" + key + ",value:" + value);
        }
        // 获取相同key的多个数据值
        String[] values = req.getParameterValues("fun");
        System.out.println("fun:"+ Arrays.toString(values));

        // 其他常用方法
        String remoteAddr = req.getRemoteAddr();
        System.out.println("远程客户端的地址：" + remoteAddr);
        String remoteHost = req.getRemoteHost();
        System.out.println("远程客户端的主机名称：" + remoteHost);
        int remotePort = req.getRemotePort();
        System.out.println("远程客户端的端口：" + remotePort);

        String localAddr = req.getLocalAddr();
        System.out.println("服务器的地址：" + localAddr);
        String localName = req.getLocalName();
        System.out.println("服务器名：" + localName);
        int localPort = req.getLocalPort();
        System.out.println("服务器端口：" + localPort);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post请求");
        this.doGet(req, resp);
    }
}
