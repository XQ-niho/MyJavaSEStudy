package com.syed.day08_inherit_polymorphism.homework;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/17 16:19
 */
public class Circle extends Shape {

    private double r;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double calGirth() {
        System.out.println("圆形周长：" + 2 * Math.PI * r);
        return 2 * Math.PI * r;
    }

    @Override
    public double calArea() {
        System.out.println("圆形面积：" + Math.PI * r * r);
        return Math.PI * r * r;
    }
}
