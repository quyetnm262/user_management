package com.jdbcservlet.user_management.service.impl;

import com.jdbcservlet.user_management.dao.IUserDao;
import com.jdbcservlet.user_management.dao.impl.UserDao;
import com.jdbcservlet.user_management.entity.UserEntity;
import com.jdbcservlet.user_management.service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private IUserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserEntity findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void add(UserEntity userEntity) {
        userDao.add(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        userDao.update(userEntity);
    }

    @Override
    public List<UserEntity> findByCondition(String name, String age, String username) {
        return userDao.findByCondition(name,age,username);
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
