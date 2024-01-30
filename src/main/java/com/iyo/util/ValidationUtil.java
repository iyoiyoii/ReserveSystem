package com.iyo.util;

public class ValidationUtil {
    private ValidationUtil(){}
    public static final String NAME="^[一-龥a-zA-Z0-9_]{1,12}$";
    public static final String USERPASSWORD="^[a-zA-Z0-9_.]{1,20}$";
    public static final String PHONENUMBER="^1[3456789]\\d{9}$";
    public static final String EMAIL="^[a-zA-Z0-9._%+-]{1,10}@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,9}$";
    public static final String USERNAME="^[a-zA-Z0-9_]{1,16}$";
    public static final String ROOMNAME="^[一-龥a-zA-Z0-9_]{1,16}$";

    public static String readLineString(String text,String regex,String message){
        String str="";
        boolean b=true;
        while(b){
            str= InputUtil.readLineString(text);
            boolean flag= StringUtil.match(str, regex);
            if(flag){
                b=false;
            }else{
                System.out.println("您输入有误，"+ message);
            }
        }
        return str;
    }

    public static Long readLineLong(String text,String regex,String message){
        long num = 0L;
        boolean b=true;
        while(b){
            num= InputUtil.readLineLong(text);
            boolean flag= StringUtil.match(String.valueOf(num), regex);
            if(flag){
                b=false;
            }else{
                System.out.println("您输入有误，"+ message);
            }
        }
        return num;
    }
}
