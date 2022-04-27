package com.syed.day08_inherit_polymorphism.polymorphismv2.entity;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 10:03
 */
public class Plane extends Vehicle {

    public Plane() {
    }

    public Plane(String brand, String type) {
        super(brand, type);
    }

    @Override
    public void move() {
        System.out.println("开" + getBrand() + getType() + "的飞机上班");
    }
}
