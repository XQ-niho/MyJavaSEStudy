package com.syed.day09_static;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 16:07
 */
public class SingletonDemoTest {
    public static void main(String[] args) {
        SingletonDemo demo1 = SingletonDemo.getInstance();
        SingletonDemo demo2 = SingletonDemo.getInstance();

        System.out.println(demo1 == demo2);
    }
}
