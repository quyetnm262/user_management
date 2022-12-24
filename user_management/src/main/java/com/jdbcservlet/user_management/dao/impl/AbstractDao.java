package com.jdbcservlet.user_management.dao.impl;


import com.jdbcservlet.user_management.dao.IGenericDao;
import com.jdbcservlet.user_management.mapper.IRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao <T> implements IGenericDao<T> {
    // tao ra connect với database
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/user_manager";
        String username = "root";
        String password = "1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> findByProperties(String sql, IRowMapper<T> mapper, Object... params){
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> data = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            setParam(preparedStatement,params);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                T object = mapper.mapFromDbToClass(resultSet);
                data.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           if (connection != null){
               try {
                   connection.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    public void insert(String sql,Object... param){
        PreparedStatement preparedStatement = null;
        Connection connection = getConnection();

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            setParam(preparedStatement,param);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
                if (connection != null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (preparedStatement != null){
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


    private void setParam(PreparedStatement preparedStatement,Object... param) throws SQLException {
        for (int i = 0; i < param.length; i++) {
            int index = i + 1;
            Object value = param[i];
            if (value instanceof String){
                preparedStatement.setString(index,(String) value);
            }else if (value instanceof Integer){
                preparedStatement.setInt(index, (Integer) value);
            }else if (value instanceof Boolean){
                preparedStatement.setBoolean(index,(Boolean) value);
            }else if (value instanceof Timestamp){
                preparedStatement.setTimestamp(index,(Timestamp) value);
            }else if (value instanceof Long){
                preparedStatement.setLong(index,(Long)value);
            }
        }
    }



}
