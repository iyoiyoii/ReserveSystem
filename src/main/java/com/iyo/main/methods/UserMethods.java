package com.iyo.main.methods;

import com.iyo.main.SysMain;
import com.iyo.pojo.User;
import com.iyo.service.ReservationService;
import com.iyo.service.UserService;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;
import com.iyo.view.AdminView;

public class UserMethods {
    UserService userService = new UserService();
    ReservationMethods reservationMethods = new ReservationMethods();
    ReservationService reservationService = new ReservationService();

    public void getUserAll(){
        PrintUtil.printUserFormat(userService.getUserAll());
    }
    public void queryUserByWord(){
        String queryWord = InputUtil.readLineString("请输入查询词:");
        PrintUtil.printUserFormat(userService.queryUserByWord(queryWord));
    }
    public void updateUser(){
        boolean flag = true;
        while (flag){
            getUserAll();
            int userId= InputUtil.readLineInt("请输入要修改的编号");
            User user = userService.queryUserById(userId);
            if (null == user){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (userService.updateUser(AdminView.displayUserUpdateView(user)))
                AdminView.showInformWithLine("修改成功");
            else
                AdminView.showInformWithLine("修改失败");
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
    public void updateUserPart(){
        boolean flag = true;
        while (flag){
            getUserAll();
            int userId= InputUtil.readLineInt("请输入要修改的编号");
            User user = userService.queryUserById(userId);
            if (null == user){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (userService.updateUser(AdminView.displayUpdateViewPart(user)))
                AdminView.showInformWithLine("修改成功");
            else
                AdminView.showInformWithLine("修改失败");
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public void updateUserPart(User user){
        boolean flag = true;
        while (flag){
            if (null == user){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (userService.updateUser(AdminView.displayUpdateViewPart(user)))
                AdminView.showInformWithLine("修改成功");
            else
                AdminView.showInformWithLine("修改失败");
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public void addUser(){
        boolean flag = true;
        while (flag){
            User user = AdminView.displayUserAddView();
            if (userService.queryUserByName(user.getUserName())!= null){
                AdminView.showInformWithLine("已经存在相同的用户账号,请重新添加");
                break;
            }
            if (userService.addUser(user))
                AdminView.showInformWithLine("新增成功");
            else
                AdminView.showInformWithLine("新增失败");
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }


    public void deleteUser(){
        boolean flag = true;
        while (flag){
            getUserAll();
            int userId = InputUtil.readLineInt("请输入要删除的用户ID:");
            if(userService.deleteUser(userId)){
                AdminView.showInformWithLine("删除成功");
            }else{
                AdminView.showInformWithLine("删除失败");
            }
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public void showUserInfo(User user) {
        PrintUtil.printUserFormat(user);
    }

    public void queryUserReservationById() {
        boolean flag = true;
        while (flag){
            getUserAll();
            int userId = InputUtil.readLineInt("请输入要查询的用户ID:");
            User user = userService.queryUserById(userId);
            if(null == user){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printReservationsFormat(reservationService.getReservationByUserId(user.getUserID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
}
