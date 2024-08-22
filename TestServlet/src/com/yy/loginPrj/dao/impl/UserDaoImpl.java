package com.yy.loginPrj.dao.impl;

import com.yy.loginPrj.dao.UserDao;
import com.yy.loginPrj.entry.User;

import java.sql.*;

/**
 * 数据库交互
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User checkUser(User user) {
        // 数据库连接对象
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs = null;
        User u = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basejava", "root", "2019");
            // 获取预处理块
            pstmt = con.prepareStatement("select  * from  user where name=? and pwd=?");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPwd());
            // 执行sql语句
            rs = pstmt.executeQuery();
            // 从resultset中获取结果值
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pwd = rs.getString("pwd");
                u = new User(id, name, pwd);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return u;
    }
}
