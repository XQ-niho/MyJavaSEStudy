package com.syed.day08_inherit_polymorphism.polymorphismv2.entity;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 9:38
 */
public class Car extends Vehicle {
    public Car() {
    }

    public Car(String brand, String type) {
        super(brand, type);
    }

    @Override
    public void move() {
        System.out.println("开" + getBrand() + getType() + "的车上班");
    }
}
