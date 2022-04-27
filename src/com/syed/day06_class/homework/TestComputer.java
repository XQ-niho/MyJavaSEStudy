package com.syed.day06_class.homework;

/**
 * @author qiu
 * @Description:
 * @date 2022/3/15 15:29
 */
public class TestComputer {
    public static void main(String[] args) {
        Screen screen = new Screen("LEB",17,"三星");
        Computer computer = new Computer("华硕",2500,"便宜");
        Computer computer1 = new Computer("华硕",2500,"便宜",screen);

        System.out.println(computer1.toString());
        computer1.printInfo();
        new Screen();

    }
}
