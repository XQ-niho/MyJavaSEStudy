package com.syed.day08_inherit_polymorphism.homework02;

import java.time.LocalDate;

/**
 * @description: 所有员工总的父类
 * @author: qiu
 * @date: 2022/3/17 16:47
 */
public class Employee {
    private String name;
    private LocalDate birthday;

    public Employee() {
    }

    public Employee(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public double getSalary(int month){
        double money = 0.0;
        if(birthday.getMonthValue() == month){
            money += 100;
        }
        return money;
    }
}
