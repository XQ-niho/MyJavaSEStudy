package com.syed.day08_inherit_polymorphism.polymorphismv1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/17 15:12
 */
public class Bike extends Vehicle {

    @Override
    public void move(){
        System.out.println("bike--ride");
    }
}