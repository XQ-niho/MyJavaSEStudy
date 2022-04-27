package com.syed.day08_inherit_polymorphism.homework;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 13:35
 */
public class ShapeFactory {
    public static final int RECT = 1;
    public static final int CIRCLE = 2;
    public static final int SQUARE = 3;

    public static Shape getShape(int type){
        Shape shape = null;
        switch (type){
            case RECT:
                shape = new Rect();
                break;
            case CIRCLE:
                shape = new Circle();
                break;
            case SQUARE:
                shape = new Square();
                break;
            default:
                System.out.println("参数有误！！");
        }
        return shape;
    }
}
