package com.syed.day03_break;


import java.util.Scanner;

/**
 * @author qiu
 * @Description: 运算符
 * @date 2022/3/7 14:38
 */
public class OperationDemo {
    public static void main(String[] args) {
        // + - * / %

        //byte 和 short在数值直接赋值时，JVM内部会自动强制类型匹配

        //byte b = (byte)126
        byte b = 126;
        //short a = (short)100
        short a = 100;

        //b =b + 1;编译错误
        b += 1;
        System.out.println(b);


        //比较运算符
        //> < >= <= == !=


        //逻辑运算符
        //与&& 或|| 非！与& 或|
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("是");
        } else {
            System.out.println("否");
        }

        //按位运算符
        // &按位与 |按位或 ^按位异或 ~取反
        System.out.println(5 & 6);
        System.out.println(5 | 6);
        System.out.println(5 ^ 6);
        System.out.println(~6);


        //移位运算符
        // >>带符号右移  <<带符号左移  >>>无符号右移


        //三目运算符

    }
}
