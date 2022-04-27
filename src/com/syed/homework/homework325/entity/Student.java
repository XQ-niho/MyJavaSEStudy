package com.syed.homework.homework325.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
@Data
@NoArgsConstructor
public class Student {
    /**学生姓名*/
    private String name;
    /**学生学号*/
    private Long id;
    private static Long sId = 201701101L;
    /**学生年龄*/
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.id = sId++;
        this.age = age;
    }
}
