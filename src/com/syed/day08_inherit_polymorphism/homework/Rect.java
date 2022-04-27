package com.syed.day08_inherit_polymorphism.homework;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/17 16:18
 */
public class Rect extends Shape {

    private double width;
    private double height;

    public Rect() {
    }

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calGirth() {
        return  2 * (width + height);
    }

    @Override
    public double calArea() {
        return width * height;
    }
}
