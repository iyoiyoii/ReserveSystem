package com.iyo.service;

import com.iyo.dao.AdminDao;
import com.iyo.dao.UserDao;
import com.iyo.pojo.Admin;
import com.iyo.pojo.User;


public class LoginService {
    AdminDao adminDao = new AdminDao();
    UserDao userDao = new UserDao();
    public boolean loginAdmin(Admin admin){
        String sql = "select * from admin where AdminName=? and AdminPassword=?";
        Object[] params = {
                admin.getAdminName(),
                admin.getAdminPassWord()
        };

        Admin sqlAdmin = adminDao.get(sql,Admin.class,params);
        if (sqlAdmin != null){
            System.out.println(sqlAdmin.getAdminID());
            return true;
        }else {
            return false;
        }
    }
    public boolean loginUser(User user){
        String sql = "select * from user where UserName=? and UserPassword=?";
        Object[] params = {
                user.getUserName(),
                user.getUserPassWord()
        };

        User sqlUser = userDao.get(sql,User.class,params);
        if (sqlUser != null){
            System.out.println(sqlUser.getName());
            return true;
        }else {
            return false;
        }
    }


}
