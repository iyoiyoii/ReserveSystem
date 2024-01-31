package com.iyo;

import com.iyo.main.SysMain;
import com.iyo.util.ExceptionUtil;

public class BootStrap {
    //主程序入口
    public static void main(String[] args) {
        try {
            SysMain.Start();
        } catch (Exception e) {
            ExceptionUtil.printException(e);
        }
    }
}
