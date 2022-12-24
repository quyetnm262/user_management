package com.jdbcservlet.user_management.utils.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static boolean isNullOrEmpty(String str){
        if (str != null && !str.equals(""))
            return false;
        return true;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static Date convertStringToDate(String date,String formatDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
