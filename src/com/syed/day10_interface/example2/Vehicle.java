package com.syed.day10_interface.example2;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 15:24
 */
public abstract class Vehicle implements Movable{

    private String brand;
    private String type;
    private double speed;

    public Vehicle() {
    }

    public Vehicle(String brand, String type, double speed) {
        this.brand = brand;
        this.type = type;
        this.speed = speed;
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

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
