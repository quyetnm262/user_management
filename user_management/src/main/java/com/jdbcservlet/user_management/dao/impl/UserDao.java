package com.jdbcservlet.user_management.dao.impl;

import com.jdbcservlet.user_management.dao.IUserDao;
import com.jdbcservlet.user_management.entity.UserEntity;
import com.jdbcservlet.user_management.mapper.UserMapper;
import com.jdbcservlet.user_management.utils.util.Util;

import java.util.List;

public class UserDao extends AbstractDao<UserEntity> implements IUserDao {
    @Override
    public List<UserEntity> findAll() {
        String sql = "select * from user";
        List<UserEntity> list = findByProperties(sql,new UserMapper());
        return list;
    }

    @Override
    public UserEntity findById(Integer id) {
        String sql = "select * from user where id = ?";
        List<UserEntity> list = findByProperties(sql,new UserMapper(), id);
        return list.get(0);
    }

    @Override
    public void add(UserEntity userEntity) {
        String sql = "insert into user(name, age, sex, address, username, password, roleId) values(?,?,?,?,?,?,?)";
        insert(sql, userEntity.getName(),userEntity.getAge(),userEntity.getSex(), userEntity.getAddress(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getRoleId());
    }

    @Override
    public void update(UserEntity user) {
        String sql = "update user set name=? ,age=? ,sex=? ,address = ?, username=?,password=? where id = ?";
        insert(sql,user.getName(),user.getAge(),user.getSex(),user.getAddress(),user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public List<UserEntity> findByCondition(String name, String ageStr, String username) {

        StringBuilder sql = new StringBuilder("select * from user where 1=1");
        if (!name.isEmpty()){
            sql.append(String.format(" and name='%s'",name));
        }
        if (!ageStr.isEmpty() && Util.isNumeric(ageStr)){
            sql.append(String.format(" and age="+Integer.parseInt(ageStr)));
        }
        if (!username.isEmpty()){
            sql.append(String.format(" and username='%s'",username));
        }
        List<UserEntity> list = findByProperties(sql.toString(),new UserMapper());

        return list;

    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {

        String sql = "select * from user where username=? and password=?";
        List<UserEntity> list = findByProperties(sql, new UserMapper(), username, password);
        return list.size()==0? null:list.get(0);
    }


}
