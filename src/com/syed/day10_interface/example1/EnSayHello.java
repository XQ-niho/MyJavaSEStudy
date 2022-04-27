package com.syed.day10_interface.example1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 14:46
 */
public class EnSayHello extends SayHello {
    @Override
    public String sayHi(String content) {
        return "Hello," + content;
    }
}
