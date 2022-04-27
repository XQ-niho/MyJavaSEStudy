package com.syed.homework.enumDemo;

import sun.applet.Main;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/20 21:36
 */
public class TestEnum {

    static Animals a;

    enum Animals {
        /**
         *
         */
        DOG("woof"), CAT("meow"), FISH("burble");
        String sound;

        Animals(String s) {
            sound = s;
        }
    }

    public static void main(String[] args) {
//        System.out.println(a.DOG.sound + " " + a.FISH.sound);

    }
}
