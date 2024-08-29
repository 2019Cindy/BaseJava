package com.yy.el;

import com.yy.el.entry.Address;
import com.yy.el.entry.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * el表达式：
 *  语法规则：
 *      ${expression},可以使用.或[]来获取属性值或指定索引位置的对象，获取值的时候，直接使用作用域中的key即可，然后使用.来引用属性，使用[]来获取指定索引位置的对象
 *  作用域：
 *      pageContext req session application
 *  获取作用域数据的顺序：
 *      从小的作用域开始查询，如果找到则会返回对应的值，
 *      当四种作用域中存在相同key值时，可以通过scope获取指定作用域的数据
 *  el表达式进行算术运算和关系运算
 *      直接在表达式中写入算法即可
 *      注意：在el表达式中的+号表示加法操作，不是字符串的连接符
 */
public class ElServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 获取请求数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name + ":" + pwd);

        // 给req设置属性
        req.setAttribute("name","111");
        // 给req添加对象
        User user = new User(1, "张三", new Address("湖北", "武汉", "仙桃"));
        User user2 = new User(2, "李四", new Address("湖南", "长沙", "长沙"));

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        req.setAttribute("user",user);
        req.setAttribute("list",users);

        HashMap<String, String> map = new HashMap<>();
        map.put("aa", "bb");
        map.put("11", "22");
        req.setAttribute("map", map);

        // 通过请求转发的方式跳转到另一个jsp页面
        req.getRequestDispatcher("el.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
