package com.syed.day10_interface.example2;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 15:49
 */
public class VehicleApp {
    public static void main(String[] args) {
        VehicleService vehicleService = VehicleService.getInstance();

        Vehicle vehicle = VehicleFactory.getVehicle(VehicleFactory.BIKE);

        vehicle.setSpeed(88.0);

        if (vehicle instanceof ICheck && vehicle.getSpeed() > 58.0) {
            System.out.println("超速了");
        } else {
            vehicleService.goToWork(vehicle);
        }

    }
}
