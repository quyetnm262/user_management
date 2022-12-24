package com.jdbcservlet.user_management.security;

import com.jdbcservlet.user_management.entity.UserEntity;
import com.jdbcservlet.user_management.service.impl.UserService;
import com.jdbcservlet.user_management.utils.SessionUtils;
import com.jdbcservlet.user_management.utils.SystemConstant;
import com.jdbcservlet.user_management.utils.UserRequest;
import com.jdbcservlet.user_management.utils.util.Util;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationImpl implements Authentication{

    private String username;
    private String password;
    private UserService userService;

    public AuthenticationImpl(UserRequest userRequest) {
        this.username = userRequest.getUsername();
        this.password = userRequest.getPassword();
        this.userService = new UserService();
    }

    @Override
    public String urlRedirect(HttpServletRequest request) {
        UserEntity userEntity = userService.findByUsernameAndPassword(this.username, this.password);

        if (userEntity == null){
            return request.getContextPath()+"/login?message="+ SystemConstant.WRONG_USER;
        }
        SessionUtils.putValue(request,"USER",userEntity);
        return request.getContextPath()+"/admin-home";
    }
}
