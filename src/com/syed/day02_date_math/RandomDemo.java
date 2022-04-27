package com.syed.day02_date_math;

import java.util.Random;

/**
 * @discription java产生随机数方式 1、Math.random()
 *                              2、java.util.Random类
 * @author qiu
 * @date 2022/3/4 14:59
 */


public class RandomDemo {
    public static void main(String[] args) {

        Random random = new Random();

        //产生int范围随机数
        int i = random.nextInt();
        //产生double范围随机数
        double d = random.nextDouble();

    }
}
