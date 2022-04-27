package com.syed.day11_object_string_packageclass;

/**
 * @description: Object类equals()方法和hashCode()方法
 *              这两个方法一般同时重写，来保证以下结论：
 *                  equals()返回true时，hashCode()的值一定要相同
 *                  equals()返回false时，hashCode()的值尽可能保证不同
 *
 * @author: qiu
 * @date: 2022/3/23 13:38
 */
public class ObjectOfEqualsAndHashCode {
    public static void main(String[] args) {
        /**
         *  == 和 equals()
         *  ==:基本类型比较真值，对象类型比较内存地址
         *  equals()：基本类型不能使用，它是负责比较对象的，默认情况比较的也是内存地址
         *  一般开发中发，对象的属性值都相同时，则我们认为是同一个对象，所以要重写equals()方法
         */

        int i = 2;
        int j = 2;

        Emp e1 = new Emp(23,1,"Jack");
        Emp e2 = new Emp(23,1,"Jack");

        //false
        System.out.println(e1 == e2);
        //重写equals()方法  true
        System.out.println(e1.equals(e2));
        //重写hashCode()方法
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}
