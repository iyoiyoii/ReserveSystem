package com.iyo.util;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputUtil {

    public InputUtil(){}
    public static String readLineString(String text){
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public static BigDecimal readLineDecimal(String text){
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        String str = "0.00";
        boolean flag = true;
        while (flag){
            str = scanner.next();
            if (StringUtil.isNumeric(str)){
                flag = false;
            }else{
                System.out.println("你输入的信息有误，请重新输入:");
            }
        }
        return new BigDecimal(str);
    }
    public static int readLineInt(String text){
        System.out.println(text);
        int num;
        while (true){
            Scanner scanner = new Scanner(System.in);
            try{
                num = scanner.nextInt();
                break;
            }catch (Exception e){
                System.out.println("请输入整数类型:");
            }
        }
        return num;
    }

    public static long readLineLong(String text){
        System.out.println(text);
        long num;
        while (true){
            Scanner scanner = new Scanner(System.in);
            try{
                num = scanner.nextLong();
                break;
            }catch (Exception e){
                System.out.println("请输入整数类型:");
            }
        }
        return num;
    }
}
