package com.syed.day08_inherit_polymorphism.homework02;

import java.time.LocalDate;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 14:06
 */
public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        Employee employee = EmployeeFactory.getEmployee(EmployeeFactory.HOURLY_EMPLOYEE);

        employee.setName("jack");
        employee.setBirthday(LocalDate.of(2022,3,4));

        HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
        hourlyEmployee.setHours(100);
        hourlyEmployee.setHourSalary(20);

        System.out.println(employeeService.calcSalary(employee,3));
    }
}
