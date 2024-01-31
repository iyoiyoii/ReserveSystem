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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeatService {
    SqlSession sqlSession;
    SeatMapper seatMapper;
    RoomMapper roomMapper;
    ReservationMapper reservationMapper;
    RoomService roomService;
    public SeatService(){
        sqlSession = SqlSessionUtil.getSqlSession();
        seatMapper = sqlSession.getMapper(SeatMapper.class);
        roomMapper = sqlSession.getMapper(RoomMapper.class);
        reservationMapper = sqlSession.getMapper(ReservationMapper.class);
        roomService = new RoomService();
    }


    public void getSeatAll(){
        sqlSession.clearCache();
        PrintUtil.printSeatsFormat(seatMapper.getSeatAll());
    }
    public void getFreeSeat(){
        PrintUtil.printSeatsFormat(seatMapper.getFreeSeat());
    }
    public void getSeatAllStatus() {
        PrintUtil.printSeatStatusFormat(seatMapper.getSeatStatusAll());
    }
    public void getSeatRoom(){
        boolean flag = true;
        while (flag){
            roomService.getRoomAll();
            int roomId= InputUtil.readLineInt("请输入要查询的编号");
            Room room = roomMapper.getRoomByID(roomId);
            if (room == null){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printSeatsFormat(seatMapper.getRoomSeat(room.getRoomID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public void getFreeSeatRoom(){
        boolean flag = true;
        while (flag){
            roomService.getRoomAll();
            int roomId= InputUtil.readLineInt("请输入要查询的编号");
            Room room = roomMapper.getRoomByID(roomId);
            if (room == null){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printSeatsFormat(seatMapper.getRoomFreeSeat(room.getRoomID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }

    public void addSeat(){
        boolean flag = true;
        while (flag){
            roomService.getRoomAll();
            int roomId= InputUtil.readLineInt("请输入房间编号");
            Room room = roomMapper.getRoomByID(roomId);
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
                seat.setRoomSeatID(room.getCapacity() + i + 1);
                seat.setRoomID(roomId);
                seat.setStatus(0);
                if (!(seatMapper.addSeat(seat) > 0))
                    bool = false;
            }
            if (bool){
                AdminView.showInformWithLine("新增成功");
                room.setCapacity(room.getCapacity() + seatCount);
                if(room.getRoomRow() < seatRow)
                    room.setRoomRow(seatRow);
                roomMapper.updateRoom(room);
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
            Room room = roomMapper.getRoomByID(roomId);
            if (null == room){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            roomService.getRoomSeatRealID(room);
            int seatId = InputUtil.readLineInt("请输入要删除的座位号");
            Seat seat = seatMapper.getSeatById(seatId);
            if(null == seat){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (seat.getStatus() == 1){
                AdminView.showInformWithLine("要删除的座位仍存在预约，请督促签离后再删除");
                flag = false;
                break;
            }
            if (seatMapper.deleteSeat(seatId) > 0){
                AdminView.showInformWithLine("删除成功");
                room.setCapacity(room.getCapacity() - 1);
                room.setRoomRow(getRoomRow(room));
                roomMapper.updateRoom(room);
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
        List<Seat> seats = seatMapper.getRoomSeatRowByRoom(room);
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
            Seat seat = seatMapper.getSeatById(seatId);
            if(null == seat){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printReservationsFormat(reservationMapper.getReservationBySeatId(seat.getSeatID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
}
