package com.yy.cookie.dao.impl;

import com.yy.cookie.dao.UserDao;
import com.yy.cookie.entry.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User checkUser(User user) {
        // 创建数据库连接
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User u = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basejava", "root", "2019");
            pstmt = conn.prepareStatement("select  * from  user where name=? and pwd=?");
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPwd());
            rs = pstmt.executeQuery();
            while (rs.next()) {
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
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return u;
    }

    @Override
    public User getUserById(int id) {
        // 创建数据库连接
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User u = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basejava", "root", "2019");
            pstmt = conn.prepareStatement("select  * from  user where id=?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String pwd = rs.getString("pwd");
                u = new User(name, pwd);
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
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return u;
    }
}
