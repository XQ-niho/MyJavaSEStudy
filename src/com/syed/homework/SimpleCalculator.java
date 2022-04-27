package com.syed.homework;

import java.io.DataOutput;

/**
 * @author qiu
 * @Description: 简易计算器
 * @date 2022/3/9 16:47
 */
public class SimpleCalculator {

    /**加法*/
    public static double sum(double a, double b){
        return a + b;
    }
    /**减法*/
    public static double sub(double a, double b){
        return a - b;
    }
    /**乘法*/
    public static double mul(double a, double b){
        return a * b;
    }
    /**除法*/
    public static double div(double a, double b){
        return a / b;
    }
    /**取余*/
    public static double mod(double a, double b){
        return a % b;
    }

}
