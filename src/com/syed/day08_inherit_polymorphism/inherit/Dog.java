package com.syed.day08_inherit_polymorphism.inherit;

/**
 * @description: 狗
 * @author: qiu
 * @date: 2022/3/17 9:23
 */
public class Dog extends Animal {

    private double loy;

    public double getLoy() {
        return loy;
    }

    public void setLoy(double loy) {
        this.loy = loy;
    }

    public void watchDoor(){
        System.out.println("狗watchDoor");
    }
}
