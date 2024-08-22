package com.yy.loginPrj.service.impl;

import com.yy.loginPrj.dao.UserDao;
import com.yy.loginPrj.dao.impl.UserDaoImpl;
import com.yy.loginPrj.entry.User;
import com.yy.loginPrj.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }
}
