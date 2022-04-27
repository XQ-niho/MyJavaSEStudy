package com.syed.day06_class.homework;

/**
 * @author qiu
 * @Description:
 * @date 2022/3/15 15:18
 */
public class Computer {

    String bream;
    double price;
    String description;

    Screen screen;

    public Computer() {
    }

    public Computer(String bream, double price, String description) {
        this.bream = bream;
        if (price < 1000 || price > 20000) {
            this.price = 2000;
        } else {
            this.price = price;
        }
        this.description = description;
    }

    public Computer(String bream, double price, String description, Screen screen) {
        this.bream = bream;
        if (price < 1000 || price > 20000) {
            this.price = 2000;
        } else {
            this.price = price;
        }
        this.description = description;
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "bream='" + bream + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", screen=" + screen +
                '}';
    }

    public void printInfo() {
        String description = "品牌" + this.bream + "价格" + this.price + "描述信息" + this.description;
        if (null == this.screen) {
            System.out.println(description);
        } else {
            System.out.println(description + screen.toString());
        }
    }
}
