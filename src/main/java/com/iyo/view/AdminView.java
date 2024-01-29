package com.iyo.view;

import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;
import com.iyo.pojo.User;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;
import com.iyo.util.ValidationUtil;

import java.security.PublicKey;
import java.util.List;

public class AdminView extends ViewBase{
    public static int displayHello() {
        PrintUtil.printLine();
        System.out.println("1、用户管理  2、自习室管理  3、座位管理  0、退出");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }

    public static int displayUserManage() {
        PrintUtil.printLine();
        System.out.println("1、查询用户信息  2、修改用户信息  0、返回");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }

    public static int displayRoomManage() {
        PrintUtil.printLine();
        System.out.println("1、查询自习室信息  2、修改自习室信息  0、返回");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }
    public static int displaySeatManage() {
        PrintUtil.printLine();
        System.out.println("1、查询座位信息  2、管理座位信息  0、返回");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }


    public static int displaySeatSelect() {
        PrintUtil.printLine();
        System.out.println("1、查询所有座位  2、查询空余座位  3、查询房间座位  4、查询房间空余座位");
        System.out.println("5、查询所有座位状态  6、查询座位预约信息  0、返回");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }

    public static int displaySeatUpdate() {
        PrintUtil.printLine();
        System.out.println("1、添加座位  2、删除座位  0、返回");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }

    public static int displayUserSelect() {
        PrintUtil.printLine();
        System.out.println("1、查询所有用户信息  2、模糊查询用户信息  3、查询用户预约信息  0、返回主菜单");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }

    public static int displayRoomSelect() {
        PrintUtil.printLine();
        System.out.println("1、查询自习室状态  2、查询自习室座位信息  3、查询自习室预约信息  0、返回主菜单");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }

    public static int displayUserUpdate() {
        PrintUtil.printLine();
        System.out.println("1、修改用户信息  2、修改指定用户信息  3、新增用户  4、删除用户   0、返回主菜单");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }

    public static int displayRoomUpdate() {
        PrintUtil.printLine();
        System.out.println("1、修改自习室名称  2、添加自习室  3、删除自习室  0、返回主菜单");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择：");
    }

    public static Room addRoomView(){
        Room room = new Room();
        String roomName = InputUtil.readLineString("请输入自习室名:");
        room.setRoomName(roomName);
        room.setCapacity(0);
        room.setCurrentOccupancy(0);
        room.setRoomRow(0);
        return room;
    }


    public static int displayUserUpdateTips(){
        PrintUtil.printLine();
        System.out.println("1、用户密码 2、用户昵称 3、用户邮箱 4、用户手机号码");
        PrintUtil.printLine();
        return InputUtil.readLineInt("请选择要修改的选项:");
    }

    public static User displayUserAddView(){
        User user = new User();
        String userName = InputUtil.readLineString("请输入用户名:");
        user.setUserName(userName);
        String userPassWord = InputUtil.readLineString("请输入用户密码:");
        user.setUserPassWord(userPassWord);
        String name = InputUtil.readLineString("请输入用户昵称:");
        user.setName(name);
        String eMail = InputUtil.readLineString("请输入用户邮箱:");
        user.setEmail(eMail);
        long phoneNumber = InputUtil.readLineLong("请输入用户手机号码:");
        user.setPhoneNumber(phoneNumber);
        return user;
    }
    public static User displayUserUpdateView(User user){
        String userPassWord = InputUtil.readLineString("请输入用户密码:");
        user.setUserPassWord(userPassWord);
        String name = InputUtil.readLineString("请输入用户昵称:");
        user.setName(name);
        String eMail = InputUtil.readLineString("请输入用户邮箱:");
        user.setEmail(eMail);
        long phoneNumber = InputUtil.readLineLong("请输入用户手机号码:");
        user.setPhoneNumber(phoneNumber);
        return user;
    }

    public static Room displayRoomUpdateView(Room room){
        String roomName = InputUtil.readLineString("请输入自习室名:");
        room.setRoomName(roomName);
        return room;
    }

    public static User displayUpdateViewPart(User user) {
        boolean flag = true;
        while (flag){
            int select = displayUserUpdateTips();
            switch (select) {
                case 1:
                    String userPassWord = InputUtil.readLineString("请输入用户密码:");
                    user.setUserPassWord(userPassWord);
                    flag = false;
                    break;
                case 2:
                    String name = InputUtil.readLineString("请输入用户昵称:");
                    user.setName(name);
                    flag = false;
                    break;
                case 3:
                    String eMail = InputUtil.readLineString("请输入用户邮箱:");
                    user.setEmail(eMail);
                    flag = false;
                    break;
                case 4:
                    long phoneNumber = InputUtil.readLineLong("请输入用户手机号码:");
                    user.setPhoneNumber(phoneNumber);
                    flag = false;
                    break;
                default:
                    InputUtil.readLineLong("没有此选项，请重新选择");
                    break;
            }
        }
        return user;
    }

    public static int displayContinue(){
        PrintUtil.printLine();
        System.out.println("1、继续 2、返回");
        PrintUtil.printLine();
        int select = 2;

        boolean flag = true;
        while (flag){
            select = InputUtil.readLineInt("请选择是否继续:");
            if(select == 1 || select == 2)
                flag = false;
        }
        return select;
    }


}
