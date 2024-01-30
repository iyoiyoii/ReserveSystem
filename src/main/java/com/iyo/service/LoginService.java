package com.iyo.service;

import com.iyo.mapper.LoginMapper;
import com.iyo.pojo.Admin;
import com.iyo.pojo.User;
import com.iyo.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;


public class LoginService {
    SqlSession sqlSession;
    LoginMapper loginMapper;
    public LoginService(){
        sqlSession = SqlSessionUtil.getSqlSession();
        loginMapper = sqlSession.getMapper(LoginMapper.class);
    }
    public boolean loginAdmin(Admin admin){
        Admin sqlAdmin = loginMapper.queryAdminNameAndPassWord(admin);
        if (sqlAdmin != null){
            System.out.println(sqlAdmin.getAdminID());
            return true;
        }else {
            return false;
        }
    }
    public boolean loginUser(User user){
        User sqlUser = loginMapper.queryUserNameAndPassWord(user);
        if (sqlUser != null){
            System.out.println(sqlUser.getName());
            return true;
        }else {
            return false;
        }
    }


}
