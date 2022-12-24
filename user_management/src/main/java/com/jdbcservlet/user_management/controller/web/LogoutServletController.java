package com.jdbcservlet.user_management.controller.web;

import com.jdbcservlet.user_management.utils.SessionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionUtils.removeValue(req,"USER");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/web/login.jsp");
        requestDispatcher.forward(req,resp);
    }
}
