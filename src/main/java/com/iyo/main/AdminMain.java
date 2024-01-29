package com.iyo.main;

import com.iyo.main.methods.RoomMethods;
import com.iyo.main.methods.SeatMethods;
import com.iyo.main.methods.UserMethods;
import com.iyo.view.AdminView;

public class AdminMain {
    RoomMethods roomMethods = new RoomMethods();
    SeatMethods seatMethods = new SeatMethods();
    UserMethods userMethods = new UserMethods();

    public void UserManager(){
        boolean flag = true;
        while (flag){
            int select = AdminView.displayUserManage();
            switch (select){
                case 1:
                    AdminView.showInformWithLineTwo("查询用户信息");
                    while (flag){
                        int selectS = AdminView.displayUserSelect();
                        switch (selectS){
                            case 1:
                                AdminView.showInformWithLineTwo("查询所有用户信息");
                                userMethods.getUserAll();
                                break;
                            case 2:
                                AdminView.showInformWithLineTwo("模糊查询用户信息");
                                userMethods.queryUserByWord();
                                break;
                            case 3:
                                AdminView.showInformWithLineTwo("查询用户预约信息");
                                userMethods.queryUserReservationById();
                                break;
                            case 0:
                                AdminView.showInformWithLineTwo("返回");
                                flag = false;
                                break;
                            default:
                                AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                                break;
                        }
                    }
                    break;
                case 2:
                    AdminView.showInformWithLineTwo("修改用户信息");
                    int selectC = AdminView.displayUserUpdate();
                    switch (selectC){
                        case 1:
                            AdminView.showInformWithLineTwo("修改用户信息");
                            userMethods.updateUser();
                            break;
                        case 2:
                            AdminView.showInformWithLineTwo("修改指定用户信息");
                            userMethods.updateUserPart();
                            break;
                        case 3:
                            AdminView.showInformWithLineTwo("新增用户");
                            userMethods.addUser();
                            break;
                        case 4:
                            AdminView.showInformWithLineTwo("删除用户");
                            userMethods.deleteUser();
                            break;
                        case 0:
                            AdminView.showInformWithLineTwo("返回");
                            flag = false;
                            break;
                        default:
                            AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                            break;
                    }
                    break;
                case 0:
                    AdminView.showInformWithLineTwo("返回");
                    flag = false;
                    break;
                default:
                    AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                    break;
            }
        }
    }
    public void RoomManager(){
        boolean flag = true;
        while (flag){
            int select = AdminView.displayRoomManage();
            switch (select){
                case 1:
                    AdminView.showInformWithLineTwo("查询自习室信息");
                    while (flag){
                        int selectS = AdminView.displayRoomSelect();
                        switch (selectS){
                            case 1:
                                AdminView.showInformWithLineTwo("查询自习室状态");
                                roomMethods.getRoomAll();
                                break;
                            case 2:
                                AdminView.showInformWithLineTwo("查询自习室座位布局");
                                roomMethods.getRoomSeat();
                                break;
                            case 3:
                                AdminView.showInformWithLineTwo("查询自习室预约信息");
                                roomMethods.queryRoomReservationById();
                                break;
                            case 0:
                                AdminView.showInformWithLineTwo("返回");
                                flag = false;
                                break;
                            default:
                                AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                                break;
                        }
                    }
                    break;
                case 2:
                    AdminView.showInformWithLineTwo("管理自习室信息");
                    int selectC = AdminView.displayRoomUpdate();
                    switch (selectC){
                        case 1:
                            AdminView.showInformWithLineTwo("修改自习室名称");
                            roomMethods.updateRoomName();
                            break;
                        case 2:
                            AdminView.showInformWithLineTwo("添加自习室");
                            roomMethods.addRoom();
                            break;
                        case 3:
                            AdminView.showInformWithLineTwo("删除自习室");
                            roomMethods.deleteRoom();
                            break;
                        case 0:
                            AdminView.showInformWithLineTwo("返回");
                            flag = false;
                            break;
                        default:
                            AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                            break;
                    }
                    break;
                case 0:
                    AdminView.showInformWithLineTwo("返回");
                    flag = false;
                    break;
                default:
                    AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                    break;
            }
        }
    }
    public void SeatManager(){
        boolean flag = true;
        while (flag){
            int selectT = AdminView.displaySeatManage();
            switch (selectT){
                case 1:
                    AdminView.showInformWithLineTwo("查询座位信息");
                    while (flag){
                        int selectS = AdminView.displaySeatSelect();
                        switch (selectS){
                            case 1:
                                AdminView.showInformWithLineTwo("查询所有座位");
                                seatMethods.getSeatAll();
                                break;
                            case 2:
                                AdminView.showInformWithLineTwo("查询空余座位");
                                seatMethods.getFreeSeat();
                                break;
                            case 3:
                                AdminView.showInformWithLineTwo("查询房间座位");
                                seatMethods.getSeatRoom();
                                break;
                            case 4:
                                AdminView.showInformWithLineTwo("查询房间空余座位");
                                seatMethods.getFreeSeatRoom();
                                break;
                            case 5:
                                AdminView.showInformWithLineTwo("查询所有座位状态");
                                seatMethods.getSeatAllStatus();
                                break;
                            case 6:
                                AdminView.showInformWithLineTwo("查询座位预约信息");
                                seatMethods.querySeatReservationById();
                                break;

                            case 0:
                                AdminView.showInformWithLineTwo("返回");
                                flag = false;
                                break;
                            default:
                                AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                                break;
                        }
                    }
                    break;
                case 2:
                    AdminView.showInformWithLineTwo("管理座位信息");
                    int selectC = AdminView.displaySeatUpdate();
                    switch (selectC){
                        case 1:
                            AdminView.showInformWithLineTwo("添加座位");
                            seatMethods.addSeat();
                            break;
                        case 2:
                            AdminView.showInformWithLineTwo("删除座位");
                            seatMethods.deleteSeat();
                            break;
                        case 0:
                            AdminView.showInformWithLineTwo("返回");
                            flag = false;
                            break;
                        default:
                            AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                            break;
                    }
                    break;
                case 0:
                    AdminView.showInformWithLineTwo("返回");
                    flag = false;
                    break;
                default:
                    AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                    break;
            }
        }
    }
}
