package com.iyo.view;

import com.iyo.util.PrintUtil;

public class ViewBase {
    public static void showInformWithLineTwo(String text){
        PrintUtil.printLine();
        System.out.println(text);
        PrintUtil.printLine();
    }
    public static void showInform(String text){
        System.out.println(text);
    }
    public static void showInformWithLine(String text){
        PrintUtil.printLine();
        System.out.println(text);
    }
}
