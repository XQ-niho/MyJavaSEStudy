package com.syed.day02_date_math;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qiu
 * @Description: java.util.Date, 老版日期类
 * @date 2022/3/4 15:14
 */
public class DateDemo {
    public static void main(String[] args) {

        //获取系统当前时间
        Date date = new Date();

        //获取日期相关信息
        //已过时，不推荐使用
        int year = date.getYear();
        System.out.println(year);

        //格式化日期
        /*
        y年 , M月, d日, H时, m分, s秒
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

}
