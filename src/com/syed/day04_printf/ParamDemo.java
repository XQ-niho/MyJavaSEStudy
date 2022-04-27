package com.syed.day04_printf;

import java.util.Arrays;

/**
 * @author qiu
 * @Description: Java参数传递
 * 1、值传递：基本类型（和一些特殊的对象类型String,Date...）采用的是值传递的方式，
 * 即把基本类型的值拷贝一份给方法传参
 *
 * 2、引用传递：
 *
 * 基本类型不会太大，所以传递时拷贝一份，操作过程不会影响原数据
 * 对象类型的系统资源可能很大，拷贝一份太浪费系统资源
 * @date 2022/3/10 13:46
 */
public class ParamDemo {
    public static void main(String[] args) {
        int num = 10;
        add(num);
        System.out.println(num);

        int[] arr = {2,3,4};
        add(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void add(int num) {
        num++;
        System.out.println(num);
    }

    public static void add(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] += 1;
        }
    }
}
