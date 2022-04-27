package com.syed.phasetest;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-21
 */
public class Print {

    public static void main(String[] args) {
        Student stu1 = new Student("张三", 20, LocalDate.of(2022, 11, 26));
        Student stu2 = new Student("李四", 22, LocalDate.of(2022, 10, 26));
        List<Student> studentList = new ArrayList<>();
        studentList.add(stu1);
        studentList.add(stu2);
        printList(studentList);

        Car car1 = new Car("奥迪", "Q5", 500000.0);
        Car car2 = new Car("奇瑞", "QQ", 200000.0);
        Car car3 = new Car("宝马", "iX3", 250000.0);
        List<Car> carsList = new ArrayList<>();
        carsList.add(car1);
        carsList.add(car2);
        carsList.add(car3);
        printList(carsList);
    }

    public static <T> void printList(List<T> list) {
        Class<?> tClass = list.get(0).getClass();
        Field[] declaredFields = tClass.getDeclaredFields();
        for (Field field : declaredFields) {
            FieldNameAnnotation annotation = field.getAnnotation(FieldNameAnnotation.class);
            String fieldName = annotation.fieldName();
            System.out.print(fieldName + "\t\t");
        }
        System.out.println();
        for (T e : list) {
            System.out.println(e);
        }
    }
}

