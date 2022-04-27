package com.syed.day08_inherit_polymorphism.inherit;

/**
 * @description: 测试类
 * @author: qiu
 * @date: 2022/3/17 9:32
 */
public class TestAnimal{
    public static void main(String[] args) {

        Cat cat = new Cat();
        Cat cat1 = new Cat("灰色","加菲猫",99.6);
        cat.setColor("橘猫");
        cat.setType("蓝猫");
        cat.setMeng(99.99);
        System.out.println(cat.getColor());
        System.out.println(cat.getType());
        System.out.println(cat.getMeng());
        cat.catchMouse();


        Dog dog = new Dog();
        dog.setType("哈士奇");
        dog.setColor("黑白");
        dog.setLoy(23.9);
        System.out.println(dog.getType());
        System.out.println(dog.getColor());
        System.out.println(dog.getLoy());
        dog.watchDoor();

    }
}
