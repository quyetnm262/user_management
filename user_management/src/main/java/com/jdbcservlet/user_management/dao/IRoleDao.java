package com.jdbcservlet.user_management.dao;

import com.jdbcservlet.user_management.entity.RoleEntity;

public interface IRoleDao {
    RoleEntity findRoleById(Integer id);
}
