package com.syed.day07;

/**
 * @description: User类测试
 * @author: qiu
 * @date: 2022/3/16 15:00
 */
public class TestUser {
    public static void main(String[] args) {
        User user = new User("习大大","123455");
        user.setUsername("习大大");
        System.out.println(user.getUsername());
    }
}
