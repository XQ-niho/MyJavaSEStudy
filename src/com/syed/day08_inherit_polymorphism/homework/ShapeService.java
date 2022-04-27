package com.syed.day08_inherit_polymorphism.homework;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 13:43
 */
public class ShapeService {

    public double lenght(Shape shape){
        return shape.calGirth();
    }

    public double area(Shape shape){
        return shape.calArea();
    }
}
