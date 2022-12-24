package com.jdbcservlet.user_management.mapper;


import com.jdbcservlet.user_management.entity.UserEntity;
import com.jdbcservlet.user_management.utils.MapUtils;

import java.sql.ResultSet;

public class UserMapper implements IRowMapper<UserEntity>{
    @Override
    public UserEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new UserEntity(),resultSet);
    }
}
