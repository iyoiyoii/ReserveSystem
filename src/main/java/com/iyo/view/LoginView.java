package com.iyo.view;

import com.iyo.pojo.Admin;
import com.iyo.pojo.User;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;

public class LoginView extends ViewBase{
    public static int displayHello(){
        PrintUtil.printLine();
        System.out.println("1、用户登录  2、管理员登录");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }
    public static Admin adminLoginView(){
        PrintUtil.printLine();
        String adminName = InputUtil.readLineString("请输入用户账号：");
        String adminPassword = InputUtil.readLineString("请输入密码：");
        return new Admin(adminName,adminPassword);
    }

    public static User userLoginMenu(){
        PrintUtil.printLine();
        String userName = InputUtil.readLineString("请输入用户名：");
        String userPassword = InputUtil.readLineString("请输入密码：");
        return new User(userName,userPassword);
    }
}
