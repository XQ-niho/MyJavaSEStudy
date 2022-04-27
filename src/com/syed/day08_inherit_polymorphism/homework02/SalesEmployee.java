package com.syed.day08_inherit_polymorphism.homework02;

import java.time.LocalDate;

/**
 * @description: 销售人员
 * @author: qiu
 * @date: 2022/3/17 16:56
 */
public class SalesEmployee extends Employee {
    private int saleOfMonth;
    private double commissionRate;

    public SalesEmployee() {
    }

    public SalesEmployee(String name, LocalDate birthday, int saleOfMonth, double commissionRate) {
        super(name, birthday);
        this.saleOfMonth = saleOfMonth;
        this.commissionRate = commissionRate;
    }

    public int getSaleOfMonth() {
        return saleOfMonth;
    }

    public void setSaleOfMonth(int saleOfMonth) {
        this.saleOfMonth = saleOfMonth;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public double getSalary(int month) {
        return super.getSalary(month) + saleOfMonth * commissionRate;
    }
}
