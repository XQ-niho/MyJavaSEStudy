package com.syed.day10_interface.example1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 14:35
 */
public class Client {
    public static void main(String[] args) {
        SayHelloService sayHelloService = new SayHelloService();
        SayHello zhSayHello = SayHelloFactory.getHelloWord(SayHelloFactory.SAY_BY_ZH);
        System.out.println(sayHelloService.sayHello(zhSayHello,"Java"));
    }
}
