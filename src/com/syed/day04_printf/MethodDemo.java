package com.syed.day04_printf;

import com.syed.util.DateUtil;

import java.util.Date;

/**
 * @author qiu
 * @Description: Java方法
 * @date 2022/3/9 10:45
 *
 *
 * 修饰符：
 * 1、普通修饰符static, final, abstract, native,
 *   访问控制修饰符
 *   public, protected, default, private
 *
 *
 */
public class MethodDemo {
    public static void main(String[] args) {

        //在自己类中调用自己的方法时，类名可以省略//print99();
        System.out.println(isPrimeNumber(10));

        System.out.println(gcd(27,18));

        Date date = DateUtil.creatDate(2002,5,4);
        String formatDate= DateUtil.dateFormat(date, "yyyy-MM-dd");
        System.out.println(formatDate);
    }

    public static void print99() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }
    }

    public static int sumNumber(int a, int b) {
        return a + b;
    }

    public static boolean isPrimeNumber(int number){
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
               return false;
            }
        }
        return true;
    }

    public static int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }



}
