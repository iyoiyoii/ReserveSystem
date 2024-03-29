package com.iyo.pojo;

public class User {
    private int UserID;
    private String UserName;
    private String UserPassWord;
    private String Email;
    private String Name;
    private long PhoneNumber;
    private int CurrentReservationID;

    public User(){}
    public User(String userName,String passWord){
        this.UserName = userName;
        this.UserPassWord = passWord;
    }

    public User(String userName, String userPassWord, String name, String eMail, int phoneNumber) {
        this.UserName = userName;
        this.UserPassWord = userPassWord;
        this.Name = name;
        this.Email = eMail;
        this.PhoneNumber = phoneNumber;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassWord() {
        return UserPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        UserPassWord = userPassWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getCurrentReservationID() {
        return CurrentReservationID;
    }

    public void setCurrentReservationID(int currentReservationID) {
        CurrentReservationID = currentReservationID;
    }

    @Override
    public String toString() {
        return UserID + ("\t\t") + UserName + ("\t\t")
                + Name  + ("\t\t\t") + Email  + ("\t\t")
                + PhoneNumber  + ("\t") + CurrentReservationID;
    }
}
