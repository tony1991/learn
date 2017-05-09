package com.alibaba.spring.ioc.service.imp;

import com.alibaba.spring.ioc.dao.UserDao;
import com.alibaba.spring.ioc.model.User;
import com.alibaba.spring.ioc.service.UserService;

public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
