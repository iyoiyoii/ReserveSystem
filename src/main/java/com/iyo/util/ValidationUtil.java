package com.iyo.util;

public class ValidationUtil {
    private ValidationUtil(){}
    public static final String AUTHOR="^([一-龥]){2,}$";
    public static final String BOOKNAME="^[一-龥]{1,}$";
    public static final String BOOKTYPE="^[一-龥]{1,}类$";

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
}
