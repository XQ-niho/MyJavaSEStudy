package com.syed.day11_object_string_packageclass;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @description: java.text.NumberFormat数字格式化类
 * @author: qiu
 * @date: 2022/3/24 16:09
 */
public class NumberFormatDemo {
    public static void main(String[] args) {

        double d = 1234567.34;

        //获取当前系统默认的数值格式(三位一隔开，有效数字三位，四舍五入)
        NumberFormat numberFormat = NumberFormat.getInstance();

        //设置数值格式
        //设置小数部分的最大位数，超过四舍五入
        numberFormat.setMaximumFractionDigits(5);
        //设置小数部分的最小位数，不足补零
        numberFormat.setMinimumFractionDigits(4);
        //注意：整数部分需注意位数，可能出错！！！！
        //设置整数部分的最大位数
        numberFormat.setMaximumIntegerDigits(4);
        //设置整数部分的最小位数
        numberFormat.setMinimumIntegerDigits(4);

        //获取当前系统默认的货币格式(币种+三位一隔开，有效数字两位，四舍五入)
        NumberFormat numberFormat1 = NumberFormat.getCurrencyInstance();

        //转入不同国家地区来调整货币
        NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(Locale.US);


        String result = numberFormat.format(d);
        System.out.println(result);

    }
}
