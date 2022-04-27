package com.syed.day06_class;

import java.time.LocalDate;

/**
 * @author qiu
 * @Description:
 * @date 2022/3/15 13:43
 */
public class TestEmployee {
    public static void main(String[] args) {

        Address address1 = new Address("上海市","浦东新区","塘镇","创新路");
        Address address2 = new Address("上海市","浦东新区","塘镇","创新北路");
        Address[] addresses = {address1,address2};

        Student e1 = new Student();
        e1.name = "CC";
        e1.age = 21;
        e1.hireDate = LocalDate.of(2022, 12, 12);
        e1.salary = 10000.0;
        e1.addresses = addresses;

        System.out.println(e1.addresses[0].city);

        Student e2 = new Student();
        e2.name = "AA";
        e2.age = 25;
        e2.hireDate = LocalDate.of(2022, 6, 12);
        e2.salary = 10000.0;

        Student e3 = new Student();
        e3.name = "BB";
        e3.age = 22;
        e3.hireDate = LocalDate.of(2022, 7, 12);
        e3.salary = 10000.0;

        Student[] employees = {e1, e2, e3};

        for (Student e : employees) {
            System.out.println(e.name + "," + e.age + "," + e.hireDate + "," + e.salary);
        }
    }
}
