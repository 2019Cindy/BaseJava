package com.yy.cookie.service.impl;

import com.yy.cookie.dao.UserDao;
import com.yy.cookie.dao.impl.UserDaoImpl;
import com.yy.cookie.service.UserService;
import com.yy.cookie.entry.User;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
