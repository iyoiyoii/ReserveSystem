package com.iyo.main;

import com.iyo.main.methods.ReservationMethods;
import com.iyo.main.methods.RoomMethods;
import com.iyo.main.methods.UserMethods;
import com.iyo.pojo.User;
import com.iyo.service.ReservationService;
import com.iyo.service.SeatService;
import com.iyo.util.InputUtil;
import com.iyo.view.UserView;

public class UserMain {
    ReservationMethods reservationMethods = new ReservationMethods();
    UserMethods userMethods = new UserMethods();
    public void ReservationManager(){
        boolean flag = true;
        while (flag){
            int select = UserView.displayReservationManage();
            switch (select){
                case 1:
                    UserView.showInformWithLineTwo("预约");
                    reservationMethods.reserve();
                    break;
                case 2:
                    UserView.showInformWithLineTwo("签离");
                    reservationMethods.unReserve();
                    break;
                case 3:
                    UserView.showInformWithLineTwo("查看房间座位信息");
                    reservationMethods.queryRoomSeat();
                    break;
                case 0:
                    UserView.showInformWithLineTwo("返回");
                    flag = false;
                    break;
                default:
                    UserView.showInformWithLineTwo("没有此选项，请重新选择");
                    break;
            }
        }
    }

    public void UserInfoManager(){
        boolean flag = true;
        while (flag){
            int select = UserView.displayUserInfoManage();
            switch (select){
                case 1:
                    UserView.showInformWithLineTwo("查看个人信息");
                    userMethods.showUserInfo(SysMain.user);
                    break;
                case 2:
                    UserView.showInformWithLineTwo("修改个人信息");
                    userMethods.updateUserPart(SysMain.user);
                    break;
                case 3:
                    UserView.showInformWithLineTwo("查看预约信息");
                    reservationMethods.getUserReservations();
                    break;
                case 0:
                    UserView.showInformWithLineTwo("返回");
                    flag = false;
                    break;
                default:
                    UserView.showInformWithLineTwo("没有此选项，请重新选择");
                    break;
            }
        }
    }
}
