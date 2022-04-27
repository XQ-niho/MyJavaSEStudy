package com.syed.day08_inherit_polymorphism.homework02;

import java.time.LocalDate;

/**
 * @description: 有固定底薪的销售人员
 * @author: qiu
 * @date: 2022/3/17 17:29
 */
public class BasedPlusSalesEmployee extends SalesEmployee{
    private int basicSalary;

    public BasedPlusSalesEmployee() {
    }

    public BasedPlusSalesEmployee(String name, LocalDate birthday, int saleOfMonth, double commissionRate, int basicSalary) {
        super(name, birthday, saleOfMonth, commissionRate);
        this.basicSalary = basicSalary;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public double getSalary(int month) {
        return super.getSalary(month) + basicSalary;
    }
}
