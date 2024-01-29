package com.iyo.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private StringUtil(){}
    public static boolean isNull(String s){
        return s == null;
    }
    //是否匹配成功方法  输入的值与正则表达式进行匹配
    public static boolean match(String s,String regex){
        if(isNull(s)){
            return false;
        }
        return s.matches(regex);
    }

    public static boolean isNumeric(String str){
        //Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Pattern pattern = Pattern.compile("[0-9]+\\.?[0-9]*");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;
        }
        Matcher isNum = pattern.matcher(bigStr);
        return isNum.matches();
    }
}
