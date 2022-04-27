package com.syed.day08_inherit_polymorphism.polymorphismv2.entity;

/**
 * @description: 交通工具类
 * @author: qiu
 * @date: 2022/3/18 9:36
 */
public class Vehicle {

    private String brand;
    private String type;

    public Vehicle() {
    }

    public Vehicle(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void move(){
    }
}
