package com.syed.day10_interface.template;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 11:01
 */
public class TestTravel {
    public static void main(String[] args) {

        TravelService travelService = new TravelService();
        Travel wsc = new Wsc();
        travelService.travelService(wsc);

        wsc.topMethod();

        Travel travel = new Jack();
        travel.topMethod();
    }
}
