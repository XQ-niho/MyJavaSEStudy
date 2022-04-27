package com.syed.day11_object_string_packageclass;

import java.math.BigInteger;

/**
 * @description: java.Math.BigInteger 大整数
 *               java.Math.BigDecimal 大浮点
 * @author: qiu
 * @date: 2022/3/24 15:30
 */
public class BigIntegerAndBigDecimalDemo {
    public static void main(String[] args) {
        //创建大数字类型对象
        BigInteger bi1 = new BigInteger("55555555555555555555555555555555555555555");
        BigInteger bi2 = new BigInteger("22222222222222222222222222222222222222222");

        //常用属性
        BigInteger one = BigInteger.ONE;
        BigInteger zero = BigInteger.ZERO;
        BigInteger ten = BigInteger.TEN;

        //加法
        BigInteger sum = bi1.add(bi2);
        System.out.println(sum);

        //减法
        BigInteger sub = bi1.subtract(bi2);
        System.out.println(sub);

        //乘法
        BigInteger mul = bi1.multiply(bi2);
        System.out.println(mul);

        //除法
        BigInteger div = bi1.divide(bi2);
        System.out.println(div);

    }
}
