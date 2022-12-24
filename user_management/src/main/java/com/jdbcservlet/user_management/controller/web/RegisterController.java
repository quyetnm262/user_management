package com.jdbcservlet.user_management.controller.web;

import com.jdbcservlet.user_management.entity.UserEntity;
import com.jdbcservlet.user_management.service.impl.UserService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guest-register")
public class RegisterController extends HttpServlet {

    private UserService userService;
    public RegisterController() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/web/register.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        UserEntity user = getUserFromRequest(req);
        userService.add(user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/web/login.jsp");
        requestDispatcher.forward(req,resp);
    }
    private UserEntity getUserFromRequest(HttpServletRequest req) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(req.getParameter("name"));
        userEntity.setAge(Integer.parseInt(req.getParameter("age")));
        userEntity.setAddress(req.getParameter("address"));
        userEntity.setUsername(req.getParameter("username"));
        userEntity.setPassword(req.getParameter("password"));
        userEntity.setRoleId(2);
        String sex = req.getParameter("sex");
        if ("Nam".equals(sex)){
            userEntity.setSex(1);
        }else {
            userEntity.setSex(2);
        }
        return userEntity;
    }
}
