package com.syed.day10_interface.example1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/21 14:51
 */
public class SayHelloFactory {
    public static final int SAY_BY_EN = 1;
    public static final int SAY_BY_ZH = 2;
    public static final int SAY_BY_JP = 3;

    public static SayHello getHelloWord(int type) {
        SayHello sayHello = null;
        switch (type){
            case SAY_BY_EN:
                sayHello = new EnSayHello();
                break;
            case SAY_BY_ZH:
                sayHello = new ZhSayHello();
                break;
            case SAY_BY_JP:
                sayHello = new JpSayHello();
                break;
            default:
                System.out.println("參數有誤");
        }
        return sayHello;
    }
}
