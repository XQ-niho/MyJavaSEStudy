package com.syed.day03_break;

import java.time.LocalDate;

/**
 * @author qiu
 * @Description: Java分支语句，switch_case
 * @date 2022/3/8 16:34
 */
public class SwitchCaseDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        int week = localDate.getDayOfWeek().getValue();
        int month = localDate.getMonth().getValue();
        //switch括号中条件类型只能是
        //byte[Byte],short[Short],int[Int],char[Character],枚举,String(JDK7.0开始)
        switch (week){
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            default:
                System.out.println("周末");
        }

        switch(month){
            //JDK14开始支持 case 1,3,5,7,8,10,12:
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31");
                break;
            case 4:
            case 6:
            case 9:
                System.out.println("30");
            case 2:
                if(LocalDate.of(localDate.getYear(),2,1).isLeapYear()){
                    System.out.println("29");
                }else{
                    System.out.println("28");
                }
                break;
            default:
                System.out.println();
        }
    }
}
