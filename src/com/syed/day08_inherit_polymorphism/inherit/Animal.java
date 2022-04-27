package com.syed.day08_inherit_polymorphism.inherit;

/**
 * @description: 动物
 * @author: qiu
 * @date: 2022/3/17 9:24
 */
public class Animal {
    private String type;
    private String color;

    public Animal() {
    }

    public Animal(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
