package com.syed.day06_class;

import java.time.LocalDate;

/**
 * @author qiu
 * @Description: 学生类
 * @date 2022/3/15 11:03
 */
public class Student {

    /**
     * 属性
     */
    String name;
    int age;
    LocalDate hireDate;
    double salary;

    Address[] addresses;

    public Student() {
    }

    public Student(String name, int age, LocalDate hireDate, double salary) {
        this.name = name;
        this.age = age;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }

    /**
     * 方法
     */
    public void study(){
        System.out.println("student");
    }
}
