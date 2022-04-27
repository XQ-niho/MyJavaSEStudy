package com.syed.day11_object_string_packageclass;

/**
 * @description: java-.lang.Object类
 * @author: qiu
 * @date: 2022/3/23 9:23
 */
public class ObjectOfToString {
    public static void main(String[] args) {
        Emp emp = new Emp(10,1,"Jack");

        /**
         * 打印对象类型时，会自动调用Object类的toString()方法
         * return getClass().getName() + "@" + Integer.toHexString(hashCode());
         *
         * 一般开发中，需要重写toString()方法，得到真实的属性值
         * */

        System.out.println(emp);
        System.out.println(emp.toString());
    }
}
