package com.jdbcservlet.user_management.controller.web;

import com.jdbcservlet.user_management.security.Authentication;
import com.jdbcservlet.user_management.utils.MapClientToServerUtils;
import com.jdbcservlet.user_management.utils.SystemConstant;
import com.jdbcservlet.user_management.utils.UserRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (!message.isEmpty()){
            if (message.equals(SystemConstant.NOT_LOGGED_IN)){
                req.setAttribute("message","Bạn phải đăng nhập để tiếp tục!");
            }else if (message.equals(SystemConstant.PERMISSION_DENIED)){
                req.setAttribute("message","Bạn không có quyền truy cập!");
            }else if (message.equals(SystemConstant.WRONG_USER)){
                req.setAttribute("message","Thông tin tài khoản và mật khẩu không đúng!");
            }

        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/web/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRequest userRequest = MapClientToServerUtils.toModelServer(UserRequest.class,req);
        String url = Authentication.newModel(userRequest).urlRedirect(req);
        resp.sendRedirect(url);
    }
}
