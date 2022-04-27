package com.syed.day03_break;

/**
 * @author qiu
 * @Description: JDK内置转换工具
 * @date 2022/3/8 10:11
 */
public class IntegerDemo {
    public static void main(String[] args) {

        //十进制转二进制
        String toBinaryString = Integer.toBinaryString(8);
        System.out.println(toBinaryString);

        //十进制转换十六进制
        String toHexString = Integer.toHexString(10);
        System.out.println(toHexString);

        //十进制转换八进制
        String toOctalString = Integer.toOctalString(45);
        System.out.println(toOctalString);

        //任何进制转换为十进制
        int result = Integer.parseInt("1111", 2);
        System.out.println(result);

        //十六进制0x
        int i = 0x111;
        System.out.println(i);
        //八进制0
        int j = 012;
        System.out.println(j);
    }
}
