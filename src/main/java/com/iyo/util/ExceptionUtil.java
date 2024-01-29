package com.iyo.util;

public class ExceptionUtil {
    //防止工具类被实例化
    private ExceptionUtil(){}
    public static void printException(Exception exception){
        PrintUtil.printLine();
        System.out.println("出现异常");
        System.out.println("异常类型:" + exception.getClass());
        System.out.println("异常消息:" + exception.getMessage());
    }
}
