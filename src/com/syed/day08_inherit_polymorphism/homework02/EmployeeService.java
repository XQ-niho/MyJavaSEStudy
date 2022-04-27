package com.syed.day08_inherit_polymorphism.homework02;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 13:58
 */
public class EmployeeService {

    public double calcSalary(Employee employee, int month){
        return  employee.getSalary(month);
    }
}
