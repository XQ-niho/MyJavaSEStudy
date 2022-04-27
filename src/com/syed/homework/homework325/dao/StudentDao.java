package com.syed.homework.homework325.dao;

import com.syed.homework.homework325.entity.Student;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
public interface StudentDao {

    void selectAllStudent();

    Student insertStudent(Student student);

    Student deleteStudent(Long id);

    Student updateStudent(Long id, String name, Integer age);


}
