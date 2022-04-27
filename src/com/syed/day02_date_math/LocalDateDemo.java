package com.syed.day02_date_math;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author qiu
 * @Description: JDK8.0提供全新日期，用来代替Date和Calendar
 * @date 2022/3/7 10:33
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        //年月日时分秒
        LocalDateTime dateTime = LocalDateTime.now();
        //格式化
        String formatterTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(formatterTime);

        //年月日
        LocalDate date = LocalDate.now();
        System.out.println(date);

        //时分秒
        LocalTime time = LocalTime.now();
        System.out.println(time);

        //获取其他时间
        LocalDateTime newDateTime = LocalDateTime.of(2022, 12, 5, 10, 39, 6);
        System.out.println(newDateTime);

        //获取时间信息
        int year = dateTime.getYear();
        System.out.println(year);
        int month = dateTime.getMonthValue();
        System.out.println(month);
        int week = dateTime.getDayOfWeek().getValue();
        System.out.println(week);


        //日期换算
        //老版日期换算只能转换成毫秒数计算 //getTime();
        //新版日期可以直接在日期上运算

        //加10天
        LocalDateTime plusDays = dateTime.plusDays(10);
        System.out.println(plusDays);

        //加指定单位时间
        LocalDateTime plus = dateTime.plus(10, ChronoUnit.YEARS);

        //判断时间先后
        boolean after = plus.isAfter(dateTime);
        System.out.println(after);

        //把字符串转换成日期
        String str1 = "2002-02-05";
        LocalDate birthday1 = LocalDate.parse(str1);
        System.out.println(birthday1);

        String str2 = "2002/02/02";
        LocalDate birthday2 = LocalDate.parse(str2, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(birthday2);


    }
}
