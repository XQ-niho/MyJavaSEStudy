package com.syed.day10_interface.example2;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 15:30
 */
public class Bike extends Vehicle implements ICheck{
    @Override
    public void move() {
        System.out.println("自行車以" + getSpeed() + "行駛");
    }
}
