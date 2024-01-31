package com.iyo.pojo;

public class Admin {
    private int AdminID;
    private String AdminName;

    private String AdminPassWord;

    public Admin(String AdminName,String AdminPassWord){
        this.AdminName = AdminName;
        this.AdminPassWord = AdminPassWord;
    }

    public Admin(){}

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getAdminPassWord() {
        return AdminPassWord;
    }

    public void setAdminPassWord(String adminPassWord) {
        AdminPassWord = adminPassWord;
    }
}
