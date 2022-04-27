package com.syed.day10_interface.example2;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 15:39
 */
public class VehicleService {

    private static VehicleService vehicleService;

    private VehicleService(){
    }

    public static VehicleService getInstance(){
        if(null == vehicleService){
            vehicleService = new VehicleService();
        }
        return vehicleService;
    }

    public void goToWork(Vehicle vehicle){
        vehicle.move();
    }


}
