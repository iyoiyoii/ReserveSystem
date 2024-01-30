package com.iyo.main;


import com.iyo.service.ReservationService;
import com.iyo.service.UserService;
import com.iyo.view.UserView;

public class UserMain {
    ReservationService reservationService = new ReservationService();
    UserService userService = new UserService();

    public void ReservationManager(){
        boolean flag = true;
        while (flag){
            int select = UserView.displayReservationManage();
            switch (select){
                case 1:
                    UserView.showInformWithLineTwo("预约");
                    reservationService.reserve();
                    break;
                case 2:
                    UserView.showInformWithLineTwo("签离");
                    reservationService.unReserve();
                    break;
                case 3:
                    UserView.showInformWithLineTwo("查看房间座位信息");
                    reservationService.queryRoomSeat();
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
                    userService.showUserInfo(SysMain.user);
                    break;
                case 2:
                    UserView.showInformWithLineTwo("修改个人信息");
                    userService.updateUserPart(SysMain.user);
                    break;
                case 3:
                    UserView.showInformWithLineTwo("查看预约信息");
                    reservationService.getUserReservations();
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
