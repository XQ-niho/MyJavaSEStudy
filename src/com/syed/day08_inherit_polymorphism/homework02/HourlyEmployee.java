package com.syed.day08_inherit_polymorphism.homework02;

import java.time.LocalDate;

/**
 * @description: 按小时拿工资的员工
 * @author: qiu
 * @date: 2022/3/17 16:54
 */
public class HourlyEmployee extends Employee {
    private int hourSalary;
    private int hours;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, LocalDate birthday, int hourSalary, int hours) {
        super(name, birthday);
        this.hourSalary = hourSalary;
        this.hours = hours;
    }

    public int getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(int hourSalary) {
        this.hourSalary = hourSalary;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public double getSalary(int month) {
        double money = super.getSalary(month) + hours * hourSalary;
        if (hours > 160) {
            money += (hours - 160) * hourSalary * 0.5;
        }
        return money;
    }
}
