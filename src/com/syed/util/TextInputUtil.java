package com.syed.util;

import java.util.Scanner;

/**
 * @author qiu
 * @Description: 输入工具
 * @date 2022/3/9 16:19
 */
public class TextInputUtil {

    public static int getInt(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextInt();
    }

    public static double getDouble(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextDouble();
    }

    public static String getString(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextLine();
    }
}
