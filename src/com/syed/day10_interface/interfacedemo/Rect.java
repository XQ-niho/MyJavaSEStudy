package com.syed.day10_interface.interfacedemo;


/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 9:47
 */
public class Rect extends Shape {

    @Override
    public void calcLength() {
        System.out.println("Rect的calcLength");
    }

    @Override
    public void calcArea() {
        System.out.println("Rect的calcArea");
    }
}
