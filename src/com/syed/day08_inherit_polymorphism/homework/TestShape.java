package com.syed.day08_inherit_polymorphism.homework;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/17 16:20
 */
public class TestShape {
    public static void main(String[] args) {
//        Shape s1 = new Rect(3,4);
//        Shape s2 = new Circle(3);
//        Shape s3 = new Square(5);
//
//        Shape[] shapes = {s1, s2, s3};
//
//        for(Shape s: shapes){
//
//        }

        ShapeService shapeService = new ShapeService();
        Shape shape = ShapeFactory.getShape(ShapeFactory.CIRCLE);
        ((Circle)shape).setR(6);
        shapeService.area(shape);
    }
}
