package com.thoughtworks.training.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    SimpleDateFormat allFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat notTimeFormate = new SimpleDateFormat("yyyy-MM-dd");

    public String getTodayDateString() {
        return allFormate.format(new Date());
    }

    public String getTodayDateString(Date date) {
        return allFormate.format(date);
    }

    //传入几天，获取未来第几天的凌晨日期字符串
    public String getFutureDateString(int day) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_MONTH, +day);
        return notTimeFormate
                .format(calendar.getTime()) + " 00:00:00";
    }

    public Date getFutureDate(int day, Date now) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_MONTH, +day);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(notTimeFormate.format(calendar.getTime()) + " 00:00:00");
    }

    //在原日期的基础上增加分钟数
    public Date addMinutes(Date date, int movieTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, movieTime);
        Date newDate = c.getTime();
        return newDate;
    }
}
