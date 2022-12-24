package com.jdbcservlet.user_management.service;

import com.jdbcservlet.user_management.entity.RoleEntity;

public interface IRoleService {
    RoleEntity findRoleById(Integer id);
}
