package com.yy.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session: 表示会话，在一段时间内，用户与服务器之间的一系列的交互操作
 *  session对象：用户发送不同请求的时候，在服务器端保存不同请求共享数据的存储对象
 *
 *  特点：
 *      1.session是依赖cookie计数的服务器端数据存储（cookie是客户端的数据存储，session是服务器端的数据存储）
 *      2.由服务器进行创建
 *      3.每个用户独立拥有一个session对象
 *      4.默认存储时间是30分钟
 *      5.每次关闭浏览器后，重新请求会开启一个新的session对象，因为返回的JSESSION保存在浏览器的内存中，是临时cookie，所以关闭之后消失
 *
 *  作用：
 *      解决相同用户发送不同请求时的数据共享问题
 */
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 获取session对象
        HttpSession session = req.getSession();
        // get方法获取到JSESSIONID
        System.out.println("session:"+session.getId());
        // 设置session的有效期,单位是秒
        session.setMaxInactiveInterval(3*60);
        // 设置session强制失效
//        session.invalidate();
        // 向session中设置参数
        session.setAttribute("name","张三");
        resp.getWriter().write("欢迎来到session的世界！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
