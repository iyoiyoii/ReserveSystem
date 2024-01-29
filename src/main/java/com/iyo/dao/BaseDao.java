package com.iyo.dao;

import java.sql.*;
import java.util.List;

import com.iyo.util.ExceptionUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;
public class BaseDao<T> {

    private static final String URL = "jdbc:mysql://localhost:3306/zxs?characterEncoding=UTF-8&serverTimezone=UTC&useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "IYOIYO";

    // 加载驱动
    static {
        boolean result = DbUtils.loadDriver(DRIVER);
        if (!result) {
            try {
                throw new SQLException("加载驱动失败");
            } catch (SQLException e) {
                ExceptionUtil.printException(e);
            }
        }
    }

    // 创建连接
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            ExceptionUtil.printException(e);
        }
        return connection;
    }

    // 数据库访问操作
    /**
     * 返回单个对象
     */
    //实体类属性和数据库属性一致
    public <T> T get(String sql, Class<T> clazz, Object[] params) {
        T object = null;
        Connection connection = null;
        try {
            connection = getConnection();
            //QueryRunner类似Statement
            QueryRunner qRunner = new QueryRunner();
            //BeanHandler封装对象
            object = qRunner.query(connection, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            ExceptionUtil.printException(e);
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return object;
    }

    /**
     * 返回多个对象
     *
     */
    public <T> List<T> query(String sql, Class<T> clazz, Object[] params) {
        List beans = null;
        Connection connection = null;
        try {
            connection = getConnection();
            QueryRunner qRunner = new QueryRunner();
            beans = (List) qRunner.query(connection, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException e) {
            ExceptionUtil.printException(e);
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return beans ;
    }

    /**
     * 返回增删改是否成功
     */
    public boolean update(String sql, Object[] params) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = getConnection();
            QueryRunner qRunner = new QueryRunner();
            int i = qRunner.update(connection, sql, params);
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            ExceptionUtil.printException(e);
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return flag;
    }

    /**
     * 需要进行事务操作时，在同一事务管理下操作
     *
     */
    public boolean update(Connection connection, String sql, Object[] params) throws SQLException {
        boolean flag = false;
        QueryRunner qRunner = new QueryRunner();
        int i = qRunner.update(connection, sql, params);
        if (i > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * *
     * 批量操作，需要用到事务
     *
     */
    public boolean batchUpdate(Connection conn, String sql, Object[][] params) throws SQLException {
        QueryRunner qRunner = new QueryRunner();
        int result = 0;
        boolean flag = false;
        result = qRunner.batch(conn, sql, params).length;
        if (result > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 返回统计单值,主键等
     *
     */
    public Number getCount(String sql, Object[] params) {
        Number value = 0;
        Connection conn = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            value = (Number) qRunner.query(conn, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            ExceptionUtil.printException(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return value;
    }

    /**
     * 返回主键,通常是执行insert语句时返回当前的主键值
     *
     */
    public Long getCurrentKey(String sql, Object[] params) {
        Connection conn = null;
        Long key = 0L;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            key = (Long) qRunner.insert(conn, sql, new ScalarHandler<>(1), params);
        } catch (SQLException e) {
            ExceptionUtil.printException(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return key;
    }
}
