package com.syed.day08_inherit_polymorphism.inherit;

/**
 * @description: 猫
 * @author: qiu
 * @date: 2022/3/17 9:22
 */
public class Cat extends Animal {

    private double meng;

    public Cat() {
    }

    public Cat(String type, String color, double meng) {
        super(type, color);
        this.meng = meng;
    }

    public double getMeng() {
        return meng;
    }

    public void setMeng(double meng) {
        this.meng = meng;
    }


    public void catchMouse(){
        System.out.println("猫catchMouse");
    }

}
