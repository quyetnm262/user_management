package com.jdbcservlet.user_management.service.impl;

import com.jdbcservlet.user_management.dao.IRoleDao;
import com.jdbcservlet.user_management.dao.impl.RoleDao;
import com.jdbcservlet.user_management.entity.RoleEntity;
import com.jdbcservlet.user_management.service.IRoleService;

public class RoleService implements IRoleService {

    IRoleDao roleDao;

    public RoleService() {
        this.roleDao = new RoleDao();
    }

    @Override
    public RoleEntity findRoleById(Integer id) {
        return roleDao.findRoleById(id);
    }
}
