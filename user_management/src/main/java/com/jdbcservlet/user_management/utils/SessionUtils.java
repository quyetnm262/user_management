package com.jdbcservlet.user_management.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {

    // day du lieu vao session
    public static void putValue(HttpServletRequest request,String key,Object value){
        request.getSession().setAttribute(key,value);
    }

    // lay du lieu tu session
    public static Object getValue(HttpServletRequest request,String key){
       return request.getSession().getAttribute(key);
    }

    // xoa session theo key khi logout
    public static void removeValue(HttpServletRequest request,String key){
        request.getSession().removeAttribute(key);
    }
}
