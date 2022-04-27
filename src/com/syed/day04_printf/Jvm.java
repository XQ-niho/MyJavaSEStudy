package com.syed.day04_printf;

/**
 * @author qiu
 * @Description: Jvm垃圾回收器
 * @date 2022/3/10 14:39
 */
public class Jvm {
    public static void main(String[] args) {
        //垃圾回收，只能提醒，不能决定
        System.gc();
        Runtime.getRuntime().gc();
    }
}
