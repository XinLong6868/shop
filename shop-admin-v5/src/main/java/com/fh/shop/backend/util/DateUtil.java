package com.fh.shop.backend.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String FULL_DATE = "yyyy-MM-dd HH:mm:ss";
    public static final String Y_M_D = "yyyy-MM-dd";

    public static final String date2Str(Date date,String pattern){
        if (date == null){
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String result = simpleDateFormat.format(date);
        return result;
    }
    public static final Date str2Date(String dateStr, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date result = null;
        try {
            result = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static final boolean creaseDate(Date date){

        if (date != null){
            //如果时间不为空，将他装换成时间格式
            String format = DateFormatUtils.format(date, "yyyy-MM-dd");
            String format1 = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
            if (StringUtils.isNotEmpty(format) && format1.equals(format)){
                return true;
            }
        }
        return false;
    }
}
