package com.yy.cookie.dao;

import com.yy.cookie.entry.User;

public interface UserDao {
    User checkUser(User user);
    User getUserById(int id);
}
