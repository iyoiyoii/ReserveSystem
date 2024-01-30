package com.iyo.service;

import com.iyo.dao.AdminDao;
import com.iyo.dao.UserDao;
import com.iyo.mapper.LoginMapper;
import com.iyo.pojo.Admin;
import com.iyo.pojo.User;
import com.iyo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


public class LoginService {

    UserDao userDao = new UserDao();
    SqlSession sqlSession;
    LoginMapper loginMapper;
    public LoginService(){
        sqlSession = MybatisUtil.getSqlSession();
        loginMapper = sqlSession.getMapper(LoginMapper.class);
    }
    public boolean loginAdmin(Admin admin){
        Admin sqlAdmin = loginMapper.loginAdmin(admin);
        if (sqlAdmin != null){
            System.out.println(sqlAdmin.getAdminID());
            return true;
        }else {
            return false;
        }
    }
    public boolean loginUser(User user){
        User sqlUser = loginMapper.loginUser(user);
        if (sqlUser != null){
            System.out.println(sqlUser.getName());
            return true;
        }else {
            return false;
        }
    }


}
