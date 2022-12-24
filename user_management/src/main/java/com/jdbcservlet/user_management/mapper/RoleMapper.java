package com.jdbcservlet.user_management.mapper;

import com.jdbcservlet.user_management.entity.RoleEntity;
import com.jdbcservlet.user_management.utils.MapUtils;

import java.sql.ResultSet;

public class RoleMapper implements IRowMapper<RoleEntity> {
    @Override
    public RoleEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new RoleEntity(),resultSet);
    }
}
