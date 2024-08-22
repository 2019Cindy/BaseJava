package com.yy.cookie.service;

import com.yy.cookie.entry.User;

public interface UserService {
    User checkUser(User user);
    User getUserById(int id);
}
