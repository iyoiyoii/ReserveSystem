package com.iyo.service;

import com.iyo.mapper.ReservationMapper;
import com.iyo.mapper.UserMapper;
import com.iyo.pojo.User;
import com.iyo.util.InputUtil;
import com.iyo.util.PrintUtil;
import com.iyo.util.SqlSessionUtil;
import com.iyo.view.AdminView;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    SqlSession sqlSession;
    UserMapper userMapper;
    ReservationMapper reservationMapper;
    public UserService(){
        sqlSession = SqlSessionUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        reservationMapper =sqlSession.getMapper(ReservationMapper.class);
    }


    public User queryUserByName(String UserName){
        return userMapper.queryUserByName(UserName);
    }
    public void getUserAll(){
        sqlSession.clearCache();
        PrintUtil.printUserFormat(userMapper.getUserAll());
    }
    public void queryUserByWord(){
        sqlSession.clearCache();
        String queryWord = InputUtil.readLineString("请输入查询词:");
        PrintUtil.printUserFormat(userMapper.queryUserByWord(queryWord));
    }
    public void updateUser(){
        boolean flag = true;
        while (flag){
            getUserAll();
            int userId= InputUtil.readLineInt("请输入要修改的编号");
            User user = userMapper.queryUserById(userId);
            if (null == user){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (userMapper.updateUser(AdminView.displayUserUpdateView(user)) > 0)
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
            User user = userMapper.queryUserById(userId);
            if (null == user){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (userMapper.updateUser(AdminView.displayUpdateViewPart(user)) > 0)
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
            if (userMapper.updateUser(AdminView.displayUpdateViewPart(user)) > 0)
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
            if (userMapper.queryUserByName(user.getUserName())!= null){
                AdminView.showInformWithLine("已经存在相同的用户账号,请重新添加");
                break;
            }
            if (userMapper.addUser(user) > 0)
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
            User user = userMapper.queryUserById(userId);
            if(null == user){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            if (user.getCurrentReservationID() != 0){
                AdminView.showInformWithLine("要删除的用户仍存在预约，请督促签离后再删除");
                flag = false;
                break;
            }
            if(userMapper.deleteUser(userId) > 0){
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
            User user = userMapper.queryUserById(userId);
            if(null == user){
                AdminView.showInformWithLine("你选择的编号有误，请重新选择");
                break;
            }
            PrintUtil.printReservationsFormat(reservationMapper.getReservationByUserId(user.getUserID()));
            if (AdminView.displayContinue()==2)
                flag = false;
        }
    }
}
