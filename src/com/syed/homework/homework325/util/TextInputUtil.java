package com.syed.homework.homework325.util;

import java.util.Scanner;

/**
 * @author qiu
 * @Description: 输入工具
 * @date 2022/3/9 16:19
 */
public class TextInputUtil {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String hint){
        System.out.print(hint);
        return scanner.nextInt();
    }
    public static Long getLong(String hint){
        System.out.println(hint);
        return scanner.nextLong();
    }


    public static double getDouble(String hint){
        System.out.print(hint);
        return scanner.nextDouble();
    }

    public static String getString(String hint){
        System.out.print(hint);
        return scanner.next();
    }
}
