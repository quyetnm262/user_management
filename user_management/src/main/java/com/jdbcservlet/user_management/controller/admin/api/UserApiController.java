package com.jdbcservlet.user_management.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbcservlet.user_management.entity.UserEntity;
import com.jdbcservlet.user_management.service.impl.UserService;
import com.jdbcservlet.user_management.utils.BaseResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user/api")
public class UserApiController extends HttpServlet {

    private UserService service;

    public UserApiController() {
        this.service = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String ageStr = req.getParameter("age");
        List<UserEntity> userEntities = service.findByCondition(name,ageStr,username);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("200");
        baseResponse.setMessage("success");
        baseResponse.setData(userEntities);

        ObjectMapper objectMapper = new ObjectMapper();

        String json =objectMapper.writeValueAsString(baseResponse);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(json);
        writer.flush();
    }
}
