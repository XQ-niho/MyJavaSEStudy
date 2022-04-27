package com.syed.day08_inherit_polymorphism.polymorphismv2.service;

import com.syed.day08_inherit_polymorphism.polymorphismv2.entity.Vehicle;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 10:05
 */
public class VehicleService {

//    public void move(Car car) {
//        System.out.println(car.getBrand() + " " + car.getType());
//    }
//
//    public void move(Bike bike) {
//        System.out.println(bike.getBrand() + " " + bike.getType());
//    }
//
//    public void move(Plane plane) {
//        System.out.println(plane.getBrand() + " " + plane.getType());
//    }


//    public void goWork(Vehicle vehicle) {
//        if (vehicle instanceof Car) {
//            System.out.println("开"+vehicle.getBrand()+vehicle.getType()+"的车上班");
//        }
//        if (vehicle instanceof Bike) {
//            System.out.println("开"+vehicle.getBrand()+vehicle.getType()+"的自行车上班");
//        }
//        if (vehicle instanceof Plane) {
//            System.out.println("开"+vehicle.getBrand()+vehicle.getType()+"的飞机上班");
//        }
//    }

    public void goWork(Vehicle vehicle){
        vehicle.move();
    }
}
