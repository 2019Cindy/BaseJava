package com.yy.session.dao.impl;

import com.yy.session.dao.UserDao;
import com.yy.session.entry.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User checkUser(User user) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User u = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basejava","root","2019");
            pstmt = con.prepareStatement("select * from user where name=? and pwd=?");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPwd());
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
        }finally {
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
