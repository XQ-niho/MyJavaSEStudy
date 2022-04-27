package com.syed.day10_interface.example1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 14:57
 */
public class SayHelloService {

    public String sayHello(SayHello sayHello,String content){
        return sayHello.sayHi(content);
    }
}
