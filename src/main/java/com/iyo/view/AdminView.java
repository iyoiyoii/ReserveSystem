package com.iyo.view;

import com.iyo.pojo.Room;
import com.iyo.pojo.User;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;
import com.iyo.util.ValidationUtil;

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
        String roomName = ValidationUtil.readLineString("请输入自习室名:",ValidationUtil.ROOMNAME,"请输入16位以内包含汉字数字字母下划线");
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
        String userName = ValidationUtil.readLineString("请输入用户名:",ValidationUtil.USERNAME,"请输入20位以内包含数字字母下划线");
        user.setUserName(userName);
        String userPassWord = ValidationUtil.readLineString("请输入用户密码:",ValidationUtil.USERPASSWORD,"请输入20位以内包含数字字母下划线或点");
        user.setUserPassWord(userPassWord);
        String name = ValidationUtil.readLineString("请输入用户昵称:",ValidationUtil.NAME,"请输入12位以内包含汉字数字字母下划线");
        user.setName(name);
        String eMail = ValidationUtil.readLineString("请输入用户邮箱:",ValidationUtil.EMAIL,"请输入正确的邮箱格式");
        user.setEmail(eMail);
        long phoneNumber = ValidationUtil.readLineLong("请输入用户手机号码:",ValidationUtil.PHONENUMBER,"请输入正确的手机号码格式");
        user.setPhoneNumber(phoneNumber);
        return user;
    }
    public static User displayUserUpdateView(User user){
        String userPassWord = ValidationUtil.readLineString("请输入用户密码:",ValidationUtil.USERPASSWORD,"请输入20位以内包含数字字母下划线或点");
        user.setUserPassWord(userPassWord);
        String name = ValidationUtil.readLineString("请输入用户昵称:",ValidationUtil.NAME,"请输入12位以内包含汉字数字字母下划线");
        user.setName(name);
        String eMail = ValidationUtil.readLineString("请输入用户邮箱:",ValidationUtil.EMAIL,"请输入正确的邮箱格式");
        user.setEmail(eMail);
        long phoneNumber = ValidationUtil.readLineLong("请输入用户手机号码:",ValidationUtil.PHONENUMBER,"请输入正确的手机号码格式");
        user.setPhoneNumber(phoneNumber);
        return user;
    }

    public static Room displayRoomUpdateView(Room room){
        String roomName = ValidationUtil.readLineString("请输入自习室名:",ValidationUtil.ROOMNAME,"请输入16位以内包含汉字数字字母下划线");
        room.setRoomName(roomName);
        return room;
    }

    public static User displayUpdateViewPart(User user) {
        boolean flag = true;
        while (flag){
            int select = displayUserUpdateTips();
            switch (select) {
                case 1:
                    String userPassWord = ValidationUtil.readLineString("请输入用户密码:",ValidationUtil.USERPASSWORD,"请输入20位以内包含数字字母下划线或点");
                    user.setUserPassWord(userPassWord);
                    flag = false;
                    break;
                case 2:
                    String name = ValidationUtil.readLineString("请输入用户昵称:",ValidationUtil.NAME,"请输入12位以内包含汉字数字字母下划线");
                    user.setName(name);
                    flag = false;
                    break;
                case 3:
                    String eMail = ValidationUtil.readLineString("请输入用户邮箱:",ValidationUtil.EMAIL,"请输入正确的邮箱格式");
                    user.setEmail(eMail);
                    flag = false;
                    break;
                case 4:
                    long phoneNumber = ValidationUtil.readLineLong("请输入用户手机号码:",ValidationUtil.PHONENUMBER,"请输入正确的手机号码格式");
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
