package com.syed.day10_interface.example2;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 15:33
 */
public class VehicleFactory implements IConstants{

    public static Vehicle getVehicle(int type){
        Vehicle vehicle = null;
        if(type == BIKE){
            vehicle = new Bike();
        }
        else if(type == CAR){
            vehicle = new Car();
        }
        else if(type == PLANE){
            vehicle = new Plane();
        }else{
            System.out.println("參數有誤！！！");
        }
        return vehicle;
    }
}
