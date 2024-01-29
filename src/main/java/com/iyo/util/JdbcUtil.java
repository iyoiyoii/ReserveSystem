package com.iyo.util;

import java.sql.*;

public class JdbcUtil {

    //防止工具类被实例化
    private JdbcUtil(){}
    private static String url="jdbc:mysql://localhost:3306/zxs?characterEncoding=UTF-8&serverTimezone=UTC&useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false";
    private static String user="root";
    private static String password="IYOIYO";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            ExceptionUtil.printException(e);
        }
    }

    //获取数据库链接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            ExceptionUtil.printException(e);
        }
        return connection;
    }

    public static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                ExceptionUtil.printException(e);
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                ExceptionUtil.printException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                ExceptionUtil.printException(e);
            }
        }
    }
}
