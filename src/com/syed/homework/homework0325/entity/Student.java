package com.syed.homework.homework0325.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @program: MyJavaSE
 * @description: 学生类
 * @author: USER
 * @create: 2022-03-27
 */
public class Student extends People {
    /**
     * 学生学号
     */
    private Long stuId;
    /**
     * 自增id
     */
    private static Long id;
    /**
     * 入学年月
     */
    private LocalDate enterSchoolDate;

    public Student() {
    }

    public Student(String name, Integer age, long stuId, LocalDate enterSchoolDate) {
        super(name, age);
        this.stuId = id++;
        this.enterSchoolDate = enterSchoolDate;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public LocalDate getEnterSchoolDate() {
        return enterSchoolDate;
    }

    public void setEnterSchoolDate(LocalDate enterSchoolDate) {
        this.enterSchoolDate = enterSchoolDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Student student = (Student) o;
        return stuId == student.stuId &&
                Objects.equals(enterSchoolDate, student.enterSchoolDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stuId, enterSchoolDate);
    }
}
