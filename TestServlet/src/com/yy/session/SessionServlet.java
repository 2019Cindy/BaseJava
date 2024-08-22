package com.yy.session;

import javax.servlet.http.HttpServlet;

/**
 * session: 表示会话，在一段时间内，用户与服务器之间的一系列的交互操作
 *  session对象：用户发送不同请求的时候，在服务器端保存不同请求共享数据的存储对象
 *
 *  特点：
 *      1.session是依赖cookie计数的服务器端数据存储（cookie是客户端的数据存储，session是服务器端的数据存储）
 *      2.由服务器进行创建
 *      3.每个用户独立拥有一个session对象
 *      4.默认存储时间是30分钟
 */
public class SessionServlet extends HttpServlet {
}
