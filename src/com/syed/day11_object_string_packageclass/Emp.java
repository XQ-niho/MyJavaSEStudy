package com.syed.day11_object_string_packageclass;

import java.util.Arrays;
import java.util.Objects;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/23 9:24
 */
public class Emp implements Cloneable {

    private int age;
    private int id;
    private String name;
    private Emp[] emps;

    public Emp() {
    }

    public Emp(int age, int id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    public Emp(int age, int id, String name, Emp[] emps) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.emps = emps;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp[] getEmps() {
        return emps;
    }

    public void setEmps(Emp[] emps) {
        this.emps = emps;
    }

    @Override
    public boolean equals(Object obj) {
        //非空判断
        if (null == obj || getClass() != obj.getClass()) {
            return false;
        }
        //自反性判断
        if (this == obj) {
            return true;
        }
        //强制类型转换
        Emp emp = (Emp) obj;
        //判断对象中的值和原始对象的值是否相同
        return emp.getId() == id && emp.getAge() == age && emp.getName().equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        //调用父类Object的clone()方法，浅拷贝
        return super.clone();

        //深拷贝

    }

    @Override
    public String toString() {
        return "Emp{" +
                "age=" + age +
                ", id=" + id +
                ", name=" + name + ", Emps" + Arrays.toString(emps) +
                '}';
    }
}
