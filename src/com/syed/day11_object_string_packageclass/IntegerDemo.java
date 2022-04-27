package com.syed.day11_object_string_packageclass;

/**
 * @description: Java包装类
 *
 * byte ------>Byte
 * short ----->Short
 * int ------->Integer
 * long ------>Long
 * float ----->Float
 * double ---->Double
 * char ------>Character
 * boolean --->Boolean
 *
 * 优点：对象类型，默认值可以设置为null，而且自带一些功能方法可以调用
 * @author: qiu
 * @date: 2022/3/24 13:55
 */
public class IntegerDemo {
    public static void main(String[] args) {

        //创建包装类
        //方式一：通过构造方法(JDK9已过时，不推荐)
        Integer i1 = new Integer(3);
        //如果传入非数字字符串，则抛出异常：java.lang.NumberFormatException
        Integer i2 = new Integer("3");
        System.out.println(i1);
        System.out.println(i2);
        //false
        System.out.println(i1 == i2);
        //true
        System.out.println(i1.equals(i2));


        /**
         *  方式二: 自动封箱 -- 自动把基本类型转换成包装类
         *
         *  自动封箱的底层原理:
         *  本质上是调用了Integer中的一个方法valueOf();该方法定义了创建Integer对象的不同分支
         *  如果数值在-128~127之间,则采用整型缓冲来获取新对象(类似于串池),保证对象是相同的,
         *  如果数值超过这个范围,则采用new的方式来创建新对象,则内存地址是不同的!
         */
        Integer i5 = Integer.valueOf(9);
        Integer i3 = 10;
        Integer i4 = 10;
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));


        //常用属性
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        System.out.println(maxValue);
        System.out.println(minValue);

        //常用方法
        //1、比较方法:返回-1，0，1
        int compareTo = i3.compareTo(i4);
        System.out.println(compareTo);

        int compare = Integer.compare(i3,i4);
        System.out.println(compare);

        //返回boolean类型
        boolean equals = i3.equals(i4);


        //2、把字符串转换为数字，字符串必须为数字
        //注意以下方法的真正返回类型
        //  因为Integer与int之间存在自动封箱装箱，所以可以互通
        Integer decode = Integer.decode("123");
        System.out.println(decode);

        Integer valueOf = Integer.valueOf("111");
        System.out.println(valueOf);

        Integer parseInt = Integer.parseInt("123");
        System.out.println(parseInt);

        //把数字转换成字符串类型
        String str = String.valueOf(123);
        System.out.println(str);

        //技巧: 数字加上空字符串会转换成字符串类型
        System.out.println("" + 3);

        //3.进制转换方法
        String toBinaryString = Integer.toBinaryString(7);
        String toOctalString = Integer.toOctalString(8);
        String toHexString = Integer.toHexString(16);
        System.out.println(toBinaryString);
        System.out.println(toOctalString);
        System.out.println(toHexString);


    }
}
