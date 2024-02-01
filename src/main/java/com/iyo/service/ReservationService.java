package com.iyo.service;

import com.iyo.main.SysMain;
import com.iyo.mapper.ReservationMapper;
import com.iyo.mapper.RoomMapper;
import com.iyo.mapper.SeatMapper;
import com.iyo.mapper.UserMapper;
import com.iyo.pojo.Reservation;
import com.iyo.pojo.Room;
import com.iyo.pojo.Seat;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;
import com.iyo.util.SqlSessionUtil;
import com.iyo.view.UserView;
import org.apache.ibatis.session.SqlSession;

public class ReservationService {
    SqlSession sqlSession;
    ReservationMapper reservationMapper;
    RoomMapper roomMapper;
    UserMapper userMapper;
    SeatMapper seatMapper;
    RoomService roomService;
    public ReservationService(){
        sqlSession = SqlSessionUtil.getSqlSession();
        reservationMapper = sqlSession.getMapper(ReservationMapper.class);
        roomMapper = sqlSession.getMapper(RoomMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
        seatMapper = sqlSession.getMapper(SeatMapper.class);
        roomService = new RoomService();
    }
    public void reserve(){
        boolean flag = true;
        while (flag){
            if(0 != SysMain.user.getCurrentReservationID()){
                UserView.showInformWithLine("已预约，请签离后再预约");
                flag = false;
                break;
            }
            roomService.getRoomAll();
            int roomId= InputUtil.readLineInt("请输入房间编号");
            Room room = roomMapper.getRoomByID(roomId);
            if (null == room){
                UserView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            roomService.getRoomSeatID(room);
            int seatId= InputUtil.readLineInt("请输入座位编号");
            Seat seat = seatMapper.getSeatByRoomId(room,seatId);
            if (null == seat){
                UserView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if(seat.getStatus() == 1){
                UserView.showInformWithLine("你选择的编号已被预约，请重新选择");
                break;
            }
            if (reservationMapper.addReservations(SysMain.user,seat) > 0){
                UserView.showInformWithLine("预约成功");
                Reservation reservation = reservationMapper.getReservationByUserIdAndConfirmed(SysMain.user.getUserID());
                userMapper.updateUserReservation(SysMain.user,reservation.getReservationID());
                seatMapper.updateSeatStatus(seat,1);
                roomMapper.updateRoomOccupancy(room,1);
                SysMain.user = userMapper.queryUserById(SysMain.user.getUserID());
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
            Reservation reservation = reservationMapper.getReservationById(SysMain.user.getCurrentReservationID());
            if (null == reservation){
                UserView.showInformWithLine("预约记录不存在");
                flag = false;
                break;
            }
            if (reservationMapper.deleteReservations(reservation) > 0){
                userMapper.updateUserReservation(SysMain.user,0);
                Seat seat = seatMapper.getSeatFreeByID(reservation.getSeatID());
                if (null == seat){
                    UserView.showInformWithLine("座位不存在或已删除");
                    flag = false;
                    break;
                }
                else
                    seatMapper.updateSeatStatus(seat,0);
                Room room = roomMapper.getRoomByID(reservation.getRoomID());
                if (null == room){
                    UserView.showInformWithLine("房间不存在或已删除");
                    flag = false;
                    break;
                }
                else
                    roomMapper.updateRoomOccupancy(room,-1);
                UserView.showInformWithLine("签离成功");
                SysMain.user = userMapper.queryUserById(SysMain.user.getUserID());
                flag = false;
            }
            else
                UserView.showInformWithLine("签离失败，请重新选择");
        }
    }

    public void queryRoomSeat(){
        sqlSession.clearCache();
        roomService.getRoomSeat();
    }

    public void getUserReservations(){
        sqlSession.clearCache();
        PrintUtil.printReservationsFormat(reservationMapper.getReservationByUserId(SysMain.user.getUserID()));
    }
}
