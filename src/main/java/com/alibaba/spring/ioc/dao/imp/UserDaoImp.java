package com.alibaba.spring.ioc.dao.imp;

import com.alibaba.spring.ioc.dao.UserDao;
import com.alibaba.spring.ioc.model.User;

public class UserDaoImp implements UserDao {

    public void add(User user) {

        System.out.println("user is saved");

    }

}
