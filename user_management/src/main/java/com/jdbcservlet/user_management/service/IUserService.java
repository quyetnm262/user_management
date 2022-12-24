package com.jdbcservlet.user_management.service;

import com.jdbcservlet.user_management.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> findAll();
    UserEntity findById(Integer id);
    void add(UserEntity userEntity);
    void update(UserEntity userEntity);
    List<UserEntity> findByCondition(String name, String age, String username);
    UserEntity findByUsernameAndPassword(String username, String password);

}
