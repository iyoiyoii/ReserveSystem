package com.iyo.view;

import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;


public class UserView extends ViewBase{
    public static int displayHello(){
        PrintUtil.printLine();
        System.out.println("1、预约与签离  2、用户信息管理  0、退出");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }

    public static int displayReservationManage(){
        PrintUtil.printLine();
        System.out.println("1、预约  2、签离  3、查看房间座位信息  0、返回");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }


    public static int displayUserInfoManage() {
        PrintUtil.printLine();
        System.out.println("1、查看个人信息  2、修改个人信息  3、查看预约信息  0、返回");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }
}
