package com.syed.day08_inherit_polymorphism.polymorphismv2.entity;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 10:03
 */
public class Bike extends Vehicle {
    public Bike() {
    }

    public Bike(String brand, String type) {
        super(brand, type);
    }

    @Override
    public void move() {
        System.out.println("开" + getBrand() + getType() + "的自行车上班");
    }
}
