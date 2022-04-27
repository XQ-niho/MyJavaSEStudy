package com.syed.day07.v2;

/**
 * @description: 员工实体类
 * @author: qiu
 * @date: 2022/3/16 16:11
 */
public class Employee {
    private long id;
    private String name;
    private double salary;
    private Employee[] employees;

    public Employee() {
    }

    public Employee(long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(long id, String name, double salary, Employee[] employees) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}
