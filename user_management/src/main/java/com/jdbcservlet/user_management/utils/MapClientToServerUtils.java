package com.jdbcservlet.user_management.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class MapClientToServerUtils {

    public static <T> T toModelServer(Class<T> tClass, HttpServletRequest request){

        try {
            T object = tClass.newInstance();
            BeanUtils.populate(object,request.getParameterMap());
            return object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
