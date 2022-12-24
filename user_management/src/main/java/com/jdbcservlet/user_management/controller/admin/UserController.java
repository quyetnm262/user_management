package com.jdbcservlet.user_management.controller.admin;

import com.jdbcservlet.user_management.entity.UserEntity;
import com.jdbcservlet.user_management.service.IUserService;
import com.jdbcservlet.user_management.service.impl.UserService;
import com.jdbcservlet.user_management.utils.SystemConstant;
import com.jdbcservlet.user_management.utils.util.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin-user")
public class UserController extends HttpServlet {
    private IUserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
        StringBuilder view = new StringBuilder();

        if (!Util.isNullOrEmpty(type)) {
            if (!SystemConstant.ADD_ACTION.equals(type)){
                Integer id = Integer.parseInt(type);
                UserEntity user = userService.findById(id);
                req.setAttribute("userEdit",user);
            }
            view.append("/pages/user-add.jsp");


        }else {
            List<UserEntity> list = userService.findAll();
            req.setAttribute("users",list);
            view.append("/pages/user-list.jsp");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view.toString());
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if (id.equals("")){
            UserEntity userEntity = getUserFromRequest(req);
            userEntity.setRoleId(2);
            userService.add(userEntity);

        }else {
            UserEntity userEntity = getUserFromRequest(req);
            userEntity.setId(Integer.parseInt(id));
            userService.update(userEntity);
        }
        List<UserEntity> list = userService.findAll();
        req.setAttribute("users",list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/user-list.jsp");
        requestDispatcher.forward(req,resp);

    }

    private UserEntity getUserFromRequest(HttpServletRequest req){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(req.getParameter("name"));
        userEntity.setAge(Integer.parseInt(req.getParameter("age")));
        userEntity.setAddress(req.getParameter("address"));
        userEntity.setUsername(req.getParameter("username"));
        userEntity.setPassword(req.getParameter("password"));
        String sex = req.getParameter("sex");
        if ("Nam".equals(sex)){
            userEntity.setSex(1);
        }else {
            userEntity.setSex(2);
        }
        return userEntity;
    }
}
