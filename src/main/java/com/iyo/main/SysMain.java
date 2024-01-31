package com.iyo.main;

import com.iyo.pojo.Admin;
import com.iyo.pojo.User;
import com.iyo.service.LoginService;
import com.iyo.service.UserService;
import com.iyo.view.AdminView;
import com.iyo.view.LoginView;
import com.iyo.view.UserView;

public class SysMain {

    public static User user = new User();
    public static void Start() throws Exception{
        LoginService loginService = new LoginService();
        UserService userService = new UserService();

        UserMain userMain = new UserMain();
        AdminMain adminMain = new AdminMain();



        boolean loginFlag = true;
        int loginCount = 0;
        int selectUOrA = 0;
        //登录业务
        while(loginFlag){
            selectUOrA = LoginView.displayHello();
            if(selectUOrA == 1){
                user = LoginView.userLoginMenu();
                if(loginService.loginUser(user))
                {
                    user = userService.queryUserByName(user.getUserName());
                    LoginView.showInformWithLine("登录成功");
                    loginFlag = false;
                }else{
                    LoginView.showInformWithLine("登录失败,请重新登录");
                    loginCount++;
                    if (loginCount>2){
                        LoginView.showInformWithLine("登录失败超过三次，系统将自动退出");
                        System.exit(0);
                    }
                }
            }else if(selectUOrA == 2){
                Admin admin = LoginView.adminLoginView();
                if(loginService.loginAdmin(admin))
                {
                    LoginView.showInformWithLine("登录成功");
                    loginFlag = false;
                }else{
                    LoginView.showInformWithLine("登录失败,请重新登录");
                    loginCount++;
                    if (loginCount>2){
                        LoginView.showInformWithLine("登录失败超过三次，系统将自动退出");
                        System.exit(0);
                    }
                }
            }else {
                LoginView.showInformWithLine("没有此选项，请重新输入");
            }
        }

        switch (selectUOrA){
            case 1:
                //用户业务
                while (true){
                    int select = UserView.displayHello();
                    switch (select){
                        case 1:
                            UserView.showInformWithLineTwo("预约与签离");
                            userMain.ReservationManager();
                            break;
                        case 2:
                            UserView.showInformWithLineTwo("用户信息管理");
                            userMain.UserInfoManager();
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                            break;
                    }
                }
            case 2:
                //管理员业务
                while (true){
                    int select = AdminView.displayHello();
                    switch (select){
                        case 1:
                            AdminView.showInformWithLineTwo("用户管理");
                            adminMain.UserManager();
                            break;
                        case 2:
                            AdminView.showInformWithLineTwo("自习室管理");
                            adminMain.RoomManager();
                            break;
                        case 3:
                            AdminView.showInformWithLineTwo("座位管理");
                            adminMain.SeatManager();
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            AdminView.showInformWithLineTwo("没有此选项，请重新选择");
                            break;
                    }
                }
            default:
                AdminView.showInformWithLineTwo("出现异常状态，程序即将退出");
                System.exit(0);
        }
    }
}
