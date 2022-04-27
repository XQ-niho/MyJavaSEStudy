package com.syed.day08_inherit_polymorphism.polymorphismv2.factory;

import com.syed.day08_inherit_polymorphism.polymorphismv2.entity.Bike;
import com.syed.day08_inherit_polymorphism.polymorphismv2.entity.Car;
import com.syed.day08_inherit_polymorphism.polymorphismv2.entity.Plane;
import com.syed.day08_inherit_polymorphism.polymorphismv2.entity.Vehicle;

/**
 * @description: 工厂类
 * @author: qiu
 * @date: 2022/3/18 11:05
 */
public class VechicleFactory {

    public static final int BIKE = 1;
    public static final int PLANE = 2;
    public static final int CAR = 3;

    public static Vehicle getVehicle(int type) {
        Vehicle vehicle = null;
        if (type == BIKE) {
            vehicle = new Bike();
        } else if (type == PLANE) {
            vehicle = new Plane();
        }else if (type == CAR) {
            vehicle = new Car();
        } else {
            System.out.println("参数有误！");
        }
        return vehicle;
    }
}
