package com.example.core.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author issyu 30320182200070
 * @date 2021/1/19 16:57
 */
public class DateTimeUtil {

    /**
     * token有效期增加小时
     * @param date
     * @param hours
     * @return
     */
    public static Date addHours(Date date,Integer hours){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }

}
