package com.syed.day10_interface.template;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 11:21
 */
public class Jack extends Travel{
    @Override
    public void go() {
        System.out.println("开房车");
    }

    @Override
    public void play() {
        System.out.println("带一家人");
    }

    @Override
    public void back() {
        System.out.println("开飞机");
    }
}
