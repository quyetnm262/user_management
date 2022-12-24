package com.jdbcservlet.user_management.dao;

import com.jdbcservlet.user_management.entity.RoleEntity;
import com.jdbcservlet.user_management.entity.UserEntity;

import java.util.List;

public interface IUserDao {
    List<UserEntity> findAll();
    UserEntity findById(Integer id);
    void add(UserEntity userEntity);
    void update(UserEntity userEntity);
    List<UserEntity> findByCondition(String name, String age, String username);
    UserEntity findByUsernameAndPassword(String username, String password);

}
