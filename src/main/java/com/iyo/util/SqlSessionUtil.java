package com.iyo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private SqlSessionUtil(){}
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            //使用Mybatis 获取 sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            ExceptionUtil.printException(e);
        }
    }
    //Factory获取SqlSession对象
    //SqlSession完全包含了面向数据库执行Sql命令所需的所有方法
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }
}
