package com.iyo.main.methods;

import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;
import com.iyo.pojo.User;
import com.iyo.service.ReservationService;
import com.iyo.service.RoomService;
import com.iyo.service.SeatService;
import com.iyo.service.UserService;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;
import com.iyo.view.AdminView;

import java.util.List;

public class RoomMethods {
    RoomService roomService = new RoomService();
    SeatService seatService = new SeatService();
    ReservationService reservationService = new ReservationService();

    public void getRoomSeat() {
        boolean flag = true;
        while (flag){
            getRoomAll();
            int roomId= InputUtil.readLineInt("请输入要查询的编号");
            Room room = roomService.getRoomByID(roomId);
            if (null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            AdminView.showInformWithLineTwo("座位布局");
            for (int i = 0; i < room.getRoomRow(); i++) {
                List<Seat> seats = seatService.getRoomSeatRow(roomId,i + 1);
                PrintUtil.printSeatsIDFormat(seats);
                System.out.println();
            }
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
    public void getRoomSeatRealID(Room room) {
        boolean flag = true;
        while (flag){
            if (null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            AdminView.showInformWithLineTwo("座位布局");
            for (int i = 0; i < room.getRoomRow(); i++) {
                List<Seat> seats = seatService.getRoomSeatRow(room.getRoomID(),i + 1);
                PrintUtil.printSeatsRealIDFormat(seats);
                System.out.println();
            }
            flag = false;
        }
    }
    public void getRoomSeatID(Room room) {
        boolean flag = true;
        while (flag){
            if (null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            AdminView.showInformWithLineTwo("座位布局");
            for (int i = 0; i < room.getRoomRow(); i++) {
                List<Seat> seats = seatService.getRoomSeatRow(room.getRoomID(),i + 1);
                PrintUtil.printSeatsIDFormat(seats);
                System.out.println();
            }
            flag = false;
        }
    }
    public void getRoomAll() {
        PrintUtil.printRoomFormat(roomService.getRoomAll());
    }
    public void updateRoomName(){
        boolean flag = true;
        while (flag){
            getRoomAll();
            int roomId= InputUtil.readLineInt("请输入要修改的编号");
            Room room = roomService.getRoomByID(roomId);
            if (null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (roomService.updateRoom(AdminView.displayRoomUpdateView(room)))
                AdminView.showInformWithLine("修改成功");
            else
                AdminView.showInformWithLine("修改失败");
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
    public void addRoom(){
        boolean flag = true;
        while (flag){
            Room room = AdminView.addRoomView();
            if (roomService.addRoom(room))
                AdminView.showInformWithLine("修改成功");
            else
                AdminView.showInformWithLine("修改失败");
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public void deleteRoom(){
        boolean flag = true;
        while (flag){
            getRoomAll();
            int roomId = InputUtil.readLineInt("请输入要删除的房间号:");
            if(roomService.deleteRoom(roomId)){
                AdminView.showInformWithLine("删除成功");
            }else{
                AdminView.showInformWithLine("删除失败");
            }
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public void queryRoomReservationById() {
        boolean flag = true;
        while (flag){
            getRoomAll();
            int roomId = InputUtil.readLineInt("请输入要查询的房间ID:");
            Room room = roomService.getRoomByID(roomId);
            if(null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printReservationsFormat(reservationService.getReservationByRoomId(room.getRoomID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
}
