package com.syed.day08_inherit_polymorphism.polymorphismv2.test;

import com.syed.day08_inherit_polymorphism.polymorphismv2.entity.Bike;
import com.syed.day08_inherit_polymorphism.polymorphismv2.entity.Car;
import com.syed.day08_inherit_polymorphism.polymorphismv2.entity.Plane;
import com.syed.day08_inherit_polymorphism.polymorphismv2.entity.Vehicle;
import com.syed.day08_inherit_polymorphism.polymorphismv2.service.VehicleService;

import static com.syed.day08_inherit_polymorphism.polymorphismv2.factory.VechicleFactory.BIKE;
import static com.syed.day08_inherit_polymorphism.polymorphismv2.factory.VechicleFactory.getVehicle;


/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 10:03
 */
public class VehicleTest {
    public static void main(String[] args) {
        Car car = new Car("宝马","A6");
        Bike bike = new Bike("东风","4S");
        Plane plane = new Plane("南方航空","A7");

        VehicleService vehicleService = new VehicleService();
        vehicleService.goWork(car);

        //用工厂创建对象
        //Vehicle vehicle = VechicleFactory.getVehicle(VechicleFactory.BIKE);

        //静态导入方式
        Vehicle vehicle = getVehicle(BIKE);
        vehicle.setBrand("奇瑞");
        vehicle.setType("QQ");
        vehicleService.goWork(vehicle);
    }
}
