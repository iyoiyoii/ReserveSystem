package com.iyo.main.methods;

import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;
import com.iyo.service.ReservationService;
import com.iyo.service.RoomService;
import com.iyo.service.SeatService;
import com.iyo.service.UserService;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;
import com.iyo.view.AdminView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeatMethods {
    RoomMethods roomMethods = new RoomMethods();
    RoomService roomService = new RoomService();
    SeatService seatService = new SeatService();
    ReservationService reservationService = new ReservationService();

    public void getSeatAll(){
        PrintUtil.printSeatsFormat(seatService.getSeatAll());
    }
    public void getFreeSeat(){
        PrintUtil.printSeatsFormat(seatService.getFreeSeat());
    }
    public void getSeatAllStatus() {
        PrintUtil.printSeatStatusFormat(seatService.getSeatStatusAll());
    }
    public void getSeatRoom(){
        boolean flag = true;
        while (flag){
            roomService.getRoomAll();
            int roomId= InputUtil.readLineInt("请输入要查询的编号");
            Room room = roomService.getRoomByID(roomId);
            if (room == null){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printSeatsFormat(seatService.getRoomSeat(room.getRoomID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public void getFreeSeatRoom(){
        boolean flag = true;
        while (flag){
            roomService.getRoomAll();
            int roomId= InputUtil.readLineInt("请输入要查询的编号");
            Room room = roomService.getRoomByID(roomId);
            if (room == null){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printSeatsFormat(seatService.getRoomFreeSeat(room.getRoomID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public void addSeat(){
        boolean flag = true;
        while (flag){
            roomService.getRoomAll();
            int roomId= InputUtil.readLineInt("请输入房间编号");
            Room room = roomService.getRoomByID(roomId);
            if (room == null){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printRoomFormat(room);
            int seatRow = InputUtil.readLineInt("请输入房间行号");
            int seatCount = InputUtil.readLineInt("请输入要新增的座位数");
            Seat seat;

            boolean bool = true;
            for (int i = 0; i < seatCount; i++) {
                seat = new Seat();
                seat.setSeatRow(seatRow);
                seat.setRoomSeatID(room.getCapacity() + i);
                seat.setRoomID(roomId);
                seat.setStatus(0);
                if (!seatService.addSeat(seat))
                    bool = false;
            }
            if (bool){
                AdminView.showInformWithLine("新增成功");
                room.setCapacity(room.getCapacity() + seatCount);
                if(room.getRoomRow() < seatRow)
                    room.setRoomRow(seatRow);
                roomService.updateRoom(room);
            }
            else{
                AdminView.showInformWithLine("新增失败");
                // RollBack不会写先空着
            }
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
    public void deleteSeat(){
        boolean flag = true;
        while (flag){
            roomService.getRoomAll();
            int roomId= InputUtil.readLineInt("请输入房间编号");
            Room room = roomService.getRoomByID(roomId);
            if (null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            roomMethods.getRoomSeatRealID(room);
            int seatId = InputUtil.readLineInt("请输入要删除的座位号");
            if (seatService.deleteSeat(seatId)){
                AdminView.showInformWithLine("删除成功");
                room.setCapacity(room.getCapacity() - 1);
                room.setRoomRow(getRoomRow(room));
                roomService.updateRoom(room);
            }
            else{
                AdminView.showInformWithLine("删除失败");
            }
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public int getRoomRow(Room room){
        int max;
        List<Seat> seats = seatService.getRoomSeatRow(room);
        List<Integer> rows = new ArrayList<>();
        rows.add(0);
        for (Seat seat : seats) {
            rows.add(seat.getSeatRow());
        }
        max = Collections.max(rows);
        return max;
    }

    public void querySeatReservationById() {
        boolean flag = true;
        while (flag){
            getSeatAll();
            int seatId = InputUtil.readLineInt("请输入要查询的座位ID:");
            Seat seat = seatService.getSeatByID(seatId);
            if(null == seat){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printReservationsFormat(reservationService.getReservationBySeatId(seat.getSeatID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
}
