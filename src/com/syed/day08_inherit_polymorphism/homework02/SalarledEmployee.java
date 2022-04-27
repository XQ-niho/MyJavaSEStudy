package com.syed.day08_inherit_polymorphism.homework02;

import java.time.LocalDate;

/**
 * @description: 固定工资的员工
 * @author: qiu
 * @date: 2022/3/17 16:50
 */
public class SalarledEmployee extends Employee{
    private int establishMonthSalary;

    public SalarledEmployee() {
    }

    public SalarledEmployee(String name, LocalDate birthday, int establishMonthSalary) {
        super(name, birthday);
        this.establishMonthSalary = establishMonthSalary;
    }

    public int getEstablishMonthSalary() {
        return establishMonthSalary;
    }

    public void setEstablishMonthSalary(int establishMonthSalary) {
        this.establishMonthSalary = establishMonthSalary;
    }

    @Override
    public double getSalary(int month) {
        return super.getSalary(month) + establishMonthSalary;
    }
}
