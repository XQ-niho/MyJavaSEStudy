package com.syed.day13_list_set;

import java.util.Comparator;

/**
 * @program: MyJavaSE
 * @description: 比较器工厂
 * @author: USER
 * @create: 2022-03-29
 */
public class EmpComparatorFactory {
    public static final int SAL_MIN_TO_MAX = 1;
    public static final int SAL_MAX_TO_MIN = 2;
    public static final int NAME_MIN_TO_MAX = 3;
    public static final int NAME_MAX_TO_MIN = 4;
    public static final int AGE_MIN_TO_MAX = 5;
    public static final int AGE_MAX_TO_MIN = 6;

    public static Comparator<Employee> getComparator(int type) {
        if (type == SAL_MIN_TO_MAX) {
            return Comparator.comparing(Employee::getSalary);
        }
        if (type == SAL_MAX_TO_MIN) {
            return (o1, o2) -> o2.getSalary().compareTo(o1.getSalary());
        }
        if (type == NAME_MIN_TO_MAX) {
            return Comparator.comparing(Employee::getName);
        }
        if (type == NAME_MAX_TO_MIN) {
            return (o1, o2) -> o2.getName().compareTo(o1.getName());
        }
        if (type == AGE_MIN_TO_MAX) {
            return Comparator.comparing(Employee::getAge);
        }
        if (type == AGE_MAX_TO_MIN) {
            return (o1, o2) -> o2.getAge().compareTo(o1.getAge());
        } else {
            System.out.println("参数有误");
        }
        return null;
    }
}
