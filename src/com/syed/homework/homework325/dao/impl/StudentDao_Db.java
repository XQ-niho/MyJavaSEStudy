package com.syed.homework.homework325.dao.impl;

import com.syed.homework.homework325.dao.StudentDao;
import com.syed.homework.homework325.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
public class StudentDao_Db implements StudentDao{

    /**学生对象集合*/
    private List<Student> students = new ArrayList<>();

    private static StudentDao_Db studentDao_db = new StudentDao_Db();

    private StudentDao_Db() {
    }

    public static StudentDao_Db getInstance() {
        return studentDao_db;
    }

    @Override
    public void selectAllStudent() {
        students.forEach(System.out::println);
    }

    @Override
    public Student insertStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student deleteStudent(Long id) {
        Student stu = null;
        for(int i = 0; i < students.size(); i++){
            Student s = students.get(i);
            if(s.getId().equals(id)){
                stu = students.remove(i);
            }
        }
        return stu;
    }

    @Override
    public Student updateStudent(Long id, String name, Integer age) {
        Student peo = null;
        for (int i = 0; i < students.size(); i++) {
            peo = students.get(i);
            if (peo.getId().equals(id)) {
                peo.setName(name);
                peo.setAge(age);
            }
        }
        return peo;
    }
}
