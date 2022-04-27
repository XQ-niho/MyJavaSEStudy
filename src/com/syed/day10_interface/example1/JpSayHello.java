package com.syed.day10_interface.example1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 14:48
 */
public class JpSayHello extends SayHello {
    @Override
    public String sayHi(String content) {
        return "こんにち度は" + content;
    }
}
