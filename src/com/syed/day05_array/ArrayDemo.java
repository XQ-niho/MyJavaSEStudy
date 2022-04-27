package com.syed.day05_array;

import java.util.Arrays;

/**
 * @author qiu
 * @Description: Java数组基本使用
 * @date 2022/3/10 15:07
 */
public class ArrayDemo {
    public static void main(String[] args) {

        //创建数组
        int[] intArr = new int[3];

        String[] stringArr = new String[5];

        //创建并赋值
        int[] intArr1 = new int[]{2, 3, 4};

        double[] doubleArr = {2.0, 3.0, 2.0, 6.0};

        //打印数组
        //Arrays.toString()
        System.out.println(Arrays.toString(stringArr));
        System.out.println(Arrays.toString(intArr));

        //普通for
        for (int i = 0; i < intArr1.length; i++) {
            System.out.println(intArr1[i]);
        }

        //增强for
        for (double value : doubleArr) {
            System.out.println(value);
        }



        int[] numOfPrize = prizeNumber();
        for (int num : numOfPrize) {
            System.out.print(num+" ");
        }

    }

    public static int[] prizeNumber() {
        int[] prizeNum = new int[7];
        for (int i = 0; i < prizeNum.length; i++) {
            prizeNum[i] = (int) (Math.random() * 10);
        }
        return prizeNum;
    }
}
