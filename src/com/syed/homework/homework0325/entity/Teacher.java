package com.syed.homework.homework0325.entity;

import java.util.Objects;

/**
 * @program: MyJavaSE
 * @description: 教师类
 * @author: USER
 * @create: 2022-03-27
 */
public class Teacher extends People{
    /**教师编号*/
    private Long teacherId;
    /**专业名称*/
    private String professionalName;

    public Teacher() {

    }

    public Teacher(String name, Integer age, Long teacherId, String professionalName) {
        super(name, age);
        this.teacherId = teacherId;
        this.professionalName = professionalName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
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
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacherId, teacher.teacherId) &&
                Objects.equals(professionalName, teacher.professionalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), teacherId, professionalName);
    }
}
