package com.syed.day10_interface.example2;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 15:26
 */
public class Car extends Vehicle implements ICheck{
    @Override
    public void move() {
        System.out.println("汽車以" + getType() + "km/s行駛");
    }
}
