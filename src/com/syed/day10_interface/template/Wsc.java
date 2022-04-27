package com.syed.day10_interface.template;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 10:56
 */
public class Wsc extends Travel{

    @Override
    public void go() {
        System.out.println("徒步");
    }

    @Override
    public void play() {
        System.out.println("穷游");
    }

    @Override
    public void back() {
        System.out.println("徒步");
    }
}
