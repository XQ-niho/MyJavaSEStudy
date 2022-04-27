package com.syed.day10_interface.example1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 14:47
 */
public class ZhSayHello extends SayHello {

    @Override
    public String sayHi(String content) {
        return "你好，" + content;
    }
}
