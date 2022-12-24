package com.jdbcservlet.user_management.dao.impl;

import com.jdbcservlet.user_management.dao.IRoleDao;
import com.jdbcservlet.user_management.entity.RoleEntity;
import com.jdbcservlet.user_management.mapper.RoleMapper;

import java.util.List;

public class RoleDao extends AbstractDao<RoleEntity> implements IRoleDao {
    @Override
    public RoleEntity findRoleById(Integer id) {
        String sql = "select * from role where id=?";
        List<RoleEntity> roleEntities = findByProperties(sql,new RoleMapper(),id);
        return roleEntities.size() == 0 ? null : roleEntities.get(0);
    }
}
