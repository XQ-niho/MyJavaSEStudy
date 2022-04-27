package com.syed.day10_interface.example2;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 15:31
 */
public class Plane extends Vehicle {
    @Override
    public void move() {
        System.out.println("飞机以" + getSpeed() + "行驶");
    }
}
