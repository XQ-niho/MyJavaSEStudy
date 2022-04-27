package com.syed.day01_data;

import java.util.Scanner;

/**
 * @author qiu
 * @date 2022/3/4 11:21
 */
public class ScannerDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*以下会出现问题
         * 解决方法
         * 1、先使用nextLine()在使用其他
         * 2、统一使用nextLine()
         * 3、用next()代替nextLine() next()以有效字符结束
         * */

        //nextInt()以空格结束
        int number = scanner.nextInt();
        System.out.println(number);
        //nextLine()以回车结束
        String name = scanner.nextLine();
        System.out.println(name);

    }
}
