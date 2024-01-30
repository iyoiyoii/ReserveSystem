package com.iyo.service;


import com.iyo.mapper.ReservationMapper;
import com.iyo.mapper.RoomMapper;
import com.iyo.mapper.SeatMapper;
import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;
import com.iyo.util.SqlSessionUtil;
import com.iyo.view.AdminView;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoomService {
    SqlSession sqlSession;
    RoomMapper roomMapper;
    SeatMapper seatMapper;
    ReservationMapper reservationMapper;
    public RoomService(){
        sqlSession = SqlSessionUtil.getSqlSession();
        roomMapper = sqlSession.getMapper(RoomMapper.class);
        seatMapper = sqlSession.getMapper(SeatMapper.class);
        reservationMapper = sqlSession.getMapper(ReservationMapper.class);
    }

    public void getRoomSeat() {
        boolean flag = true;
        while (flag){
            getRoomAll();
            int roomId= InputUtil.readLineInt("请输入要查询的编号");
            Room room = roomMapper.getRoomByID(roomId);
            if (null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            AdminView.showInformWithLineTwo("座位布局");
            for (int i = 0; i < room.getRoomRow(); i++) {
                List<Seat> seats = seatMapper.getRoomSeatRowByIDAndRow(roomId,i + 1);
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
                List<Seat> seats = seatMapper.getRoomSeatRowByIDAndRow(room.getRoomID(),i + 1);
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
                List<Seat> seats = seatMapper.getRoomSeatRowByIDAndRow(room.getRoomID(),i + 1);
                PrintUtil.printSeatsIDFormat(seats);
                System.out.println();
            }
            flag = false;
        }
    }
    public void getRoomAll() {
        sqlSession.clearCache();
        PrintUtil.printRoomFormat(roomMapper.getRoomAll());
    }
    public void updateRoomName(){
        boolean flag = true;
        while (flag){
            getRoomAll();
            int roomId= InputUtil.readLineInt("请输入要修改的编号");
            Room room = roomMapper.getRoomByID(roomId);
            if (null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (roomMapper.updateRoom(AdminView.displayRoomUpdateView(room)) > 0)
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
            if (roomMapper.addRoom(room) > 1)
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
            if(roomMapper.deleteRoom(roomId) > 1){
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
            Room room = roomMapper.getRoomByID(roomId);
            if(null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printReservationsFormat(reservationMapper.getReservationByRoomId(room.getRoomID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
}
