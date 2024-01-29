package com.iyo.main.methods;

import com.iyo.main.SysMain;
import com.iyo.pojo.Reservation;
import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;
import com.iyo.service.ReservationService;
import com.iyo.service.RoomService;
import com.iyo.service.SeatService;
import com.iyo.service.UserService;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;
import com.iyo.view.UserView;

import java.util.List;

public class ReservationMethods {
    ReservationService reservationService = new ReservationService();
    RoomService roomService = new RoomService();
    SeatService seatService = new SeatService();
    UserService userService = new UserService();

    SeatMethods seatMethods = new SeatMethods();
    RoomMethods roomMethods = new RoomMethods();



    //预约与签离
    public void UserInfoManager(){

    }

    public void reserve(){
        boolean flag = true;
        while (flag){
            if(0 != SysMain.user.getCurrentReservationID()){
                UserView.showInformWithLine("已预约，请签离后再预约");
                flag = false;
                break;
            }
            roomMethods.getRoomAll();
            int roomId= InputUtil.readLineInt("请输入房间编号");
            Room room = roomService.getRoomByID(roomId);
            if (null == room){
                UserView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            roomMethods.getRoomSeatID(room);
            int seatId= InputUtil.readLineInt("请输入作为编号");
            Seat seat = seatService.getSeatByRoomId(room,seatId);
            if (null == seat || seat.getStatus() == 1){
                UserView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (reservationService.reserve(SysMain.user,seat)){
                UserView.showInformWithLine("预约成功");
                Reservation reservation = reservationService.getReservationByUserIdAndConfirmed(SysMain.user.getUserID());
                userService.updateUserSeat(SysMain.user,reservation.getReservationID());
                seatService.updateSeatStatus(seat,1);
                roomService.updateRoomOccupancy(room,1);
                SysMain.user = userService.queryUserById(SysMain.user.getUserID());
                flag = false;
            }
            else
                UserView.showInformWithLine("预约失败，请重新选择");
        }
    }

    public void unReserve(){
        boolean flag = true;
        while (flag){
            if(0 == SysMain.user.getCurrentReservationID()){
                UserView.showInformWithLine("不存在预约");
                flag = false;
                break;
            }
            Reservation reservation = reservationService.getReservationById(SysMain.user.getCurrentReservationID());
            if (null == reservation){
                UserView.showInformWithLine("预约记录不存在");
                flag = false;
                break;
            }
            if (reservationService.unReserve(reservation)){
                userService.updateUserSeat(SysMain.user,0);
                Seat seat = seatService.getSeatById(reservation.getSeatID());
                if (null == seat)
                    UserView.showInformWithLine("座位不存在或已删除");
                else
                    seatService.updateSeatStatus(seat,0);
                Room room = roomService.getRoomByID(reservation.getRoomID());
                if (null == room)
                    UserView.showInformWithLine("房间不存在或已删除");
                else
                    roomService.updateRoomOccupancy(room,-1);
                UserView.showInformWithLine("签离成功");
                SysMain.user = userService.queryUserById(SysMain.user.getUserID());
                flag = false;
            }
            else
                UserView.showInformWithLine("签离失败，请重新选择");
        }
    }

    public void queryRoomSeat(){
        roomMethods.getRoomSeat();
    }

    public void getUserReservations(){
        PrintUtil.printReservationsFormat(reservationService.getReservationByUserId(SysMain.user.getUserID()));
    }
}
