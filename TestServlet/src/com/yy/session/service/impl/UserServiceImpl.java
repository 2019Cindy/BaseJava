package com.yy.session.service.impl;

import com.yy.session.dao.UserDao;
import com.yy.session.dao.impl.UserDaoImpl;
import com.yy.session.entry.User;
import com.yy.session.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }
}
