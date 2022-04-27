package com.syed.day02_date_math;

/**
 * @author qiu
 * @Description: java.lang.Math, 内置数学类
 * @date 2022/3/4 14:24
 */
public class MathDemo {
    public static void main(String[] args) {
        //获取圆周率
        double pi = Math.PI;
        System.out.println(pi);

        //绝对值
        int abs = Math.abs(-8);

        //最大值最小值
        int max = Math.max(Math.max(4, 5), 2);
        int min = Math.min(5, 2);

        //平方根
        double sqrt = Math.sqrt(6);

        //幂运算
        double pow = Math.pow(2, 5);

        //向下取整
        double floor = Math.floor(3.6);

        //向上取整
        double ceil = Math.ceil(2.1);

        //四舍五入
        long round = Math.round(3.4);

        //随机数
        //默认产生[0,1)
        double random = Math.random();
        //产生指定范围随机数

    }
}
