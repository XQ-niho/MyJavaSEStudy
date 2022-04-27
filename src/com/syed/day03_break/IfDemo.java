package com.syed.day03_break;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * @author qiu
 * @Description: 分支结构(if else switch case)
 * @date 2022/3/7 13:53
 */
public class IfDemo {
    public static void main(String[] args) {

        //内置闰年判断
        //旧日期
        boolean leapYear = new GregorianCalendar().isLeapYear(2022);
        //新版
        boolean leapYear1 =
                LocalDate.of(2022,2,1).isLeapYear();
    }
}
