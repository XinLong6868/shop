package com.fh.shop.backend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String Y_M_D_h_M_S="yyyy-MM-dd HH:mm:ss";

    public static final String Y_M_D="yyyy-MM-dd";

    /**
     * 日期格式转字符串格式
     * @param date
     * @param Pattern
     * @return
     */
    public static String date2Str(Date date, String Pattern){
        if(date==null){
            return "";
        }
        SimpleDateFormat sim=new SimpleDateFormat(Pattern);
        String format = sim.format(date);
        return format;
    }

    /**
     * 字符串格式转日期格式
     * @param
     * @param Pattern
     * @return
     */
    public static Date str2Date(String dateStr, String Pattern){
        SimpleDateFormat sim=new SimpleDateFormat(Pattern);
        Date resultDate = null;
        if(dateStr==null){
            return null;
        }
        try {
            resultDate = sim.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }



}
