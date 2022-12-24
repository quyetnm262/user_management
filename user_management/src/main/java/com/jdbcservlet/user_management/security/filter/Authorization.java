package com.jdbcservlet.user_management.security.filter;

import com.jdbcservlet.user_management.entity.RoleEntity;
import com.jdbcservlet.user_management.entity.UserEntity;
import com.jdbcservlet.user_management.service.IRoleService;
import com.jdbcservlet.user_management.service.impl.RoleService;
import com.jdbcservlet.user_management.utils.SessionUtils;
import com.jdbcservlet.user_management.utils.SystemConstant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authorization implements Filter {

    private ServletContext context;
    private IRoleService roleService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.roleService = new RoleService();
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserEntity user = (UserEntity) SessionUtils.getValue(request,"USER");
        String url = request.getRequestURI();
        if (user == null && url.contains("/admin")){
            response.sendRedirect(request.getContextPath() + "/login?message="+ SystemConstant.NOT_LOGGED_IN);
        }else if(user != null && url.contains("/admin-user")){
            RoleEntity roleEntity = roleService.findRoleById(user.getRoleId());
            String type = request.getParameter("type");
            if (roleEntity.getName().equals("user") && !type.isEmpty()){
                SessionUtils.removeValue(request,"USER");
                response.sendRedirect(request.getContextPath() + "/login?message="+ SystemConstant.PERMISSION_DENIED);
            }else {
                filterChain.doFilter(request,response);
            }
        }else {
            filterChain.doFilter(request,response);
        }
    }


    @Override
    public void destroy() {

    }
}
