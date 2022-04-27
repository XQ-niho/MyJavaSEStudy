package com.syed.homework.homework325.service;

import com.syed.homework.homework325.dao.impl.StudentDao_Db;
import com.syed.homework.homework325.entity.Student;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
public class StudentService {
    StudentDao_Db dao = StudentDao_Db.getInstance();

    private static StudentService studentService = new StudentService();

    private StudentService(){

    }

    public static StudentService getStudentService(){
        return studentService;
    }

    /**
     * 添加学士
     * @param age 年龄
     * @param name 姓名
     * @return 添加成功的学生
     */
    public Student addStudent(Integer age, String name){
        Student newStudent = new Student(name,age);
        dao.insertStudent(newStudent);
        return newStudent;
    }

    public Student deleteStu(Long id){
        return dao.deleteStudent(id);
    }

    public Student changeStudentInfo(Long id ,String name, Integer age){
        return dao.updateStudent(id, name, age);
    }

    public void showAllStudent(){
        dao.selectAllStudent();
    }
}
