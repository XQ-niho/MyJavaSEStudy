package com.syed.day02_date_math;

import java.util.Calendar;

/**
 * @author qiu
 * @Description: java.util.Calendar
 * @date 2022/3/6 15:12
 */
public class CalendarDemo {
    public static void main(String[] args) {
        //创建系统当前日历
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //从日历中获取相关信息
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);

        //0-11
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);

        int hour12 = calendar.get(Calendar.HOUR_OF_DAY);
        int hour24 = calendar.get(Calendar.HOUR);

        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(week);

        //设置时间
        //month 0-11
        calendar.set(2002,Calendar.JANUARY,12,12,12,5);


    }
}
