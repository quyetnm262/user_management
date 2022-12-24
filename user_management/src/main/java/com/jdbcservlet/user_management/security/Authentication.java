package com.jdbcservlet.user_management.security;

import com.jdbcservlet.user_management.utils.UserRequest;

import javax.servlet.http.HttpServletRequest;

public interface Authentication {
    static Authentication newModel(UserRequest userRequest){
        return new AuthenticationImpl(userRequest);
    }

    String urlRedirect(HttpServletRequest request);
}
